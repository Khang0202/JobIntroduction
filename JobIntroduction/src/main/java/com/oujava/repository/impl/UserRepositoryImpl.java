/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import com.oujava.pojo.RolePermission;
import com.oujava.pojo.User;
import com.oujava.repository.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trann
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private BCryptPasswordEncoder passEncoder;
    
    @Override
    public List<User> getAllUsers() {
        Session s = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root rootUser = criteriaQuery.from(User.class);
        Root rootRole = criteriaQuery.from(Role.class);
        
        criteriaQuery.multiselect(
                rootUser.get("firstName"),
                rootUser.get("lastName"),
                rootUser.get("email"),
                rootUser.get("username"),
                rootRole.get("role"),
                rootUser.get("active")
        );
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(rootUser.get("roleId"), rootRole.get("id")));
        
        criteriaQuery.where(predicates.toArray(Predicate[]::new));
        
        Query query = s.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    @Override
    public void editRoleByUserId(int userId, int roleId) {
        Session s = sessionFactory.getCurrentSession();
        User user = s.get(User.class, userId);
        if (user != null) {
            Role role = s.get(Role.class, roleId);
            if (role != null) {
                user.setRoleId(role);
                s.update(user);
            } else {
                
            }
        } else {
            
        }
    }
    
    @Override
    public boolean editActiveByUserId(int userId, boolean active) {
        Session s = sessionFactory.getCurrentSession();
        User user = s.get(User.class, userId);
        
        if (user != null) {
            user.setActive(active);
            s.update(user);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public List<Permission> getAllPermissionByUserId(int userId) {
        Session s = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root rootUser = criteriaQuery.from(User.class);
        Root rootPermission = criteriaQuery.from(Permission.class);
        Root rootRolePermission = criteriaQuery.from(RolePermission.class);
        
        criteriaQuery.multiselect(
                rootPermission.get("id"),
                rootPermission.get("permission")
        );
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(rootUser.get("id"), userId));
        predicates.add(criteriaBuilder.equal(rootUser.get("roleId"), rootRolePermission.get("roleId")));
        predicates.add(criteriaBuilder.equal(rootRolePermission.get("permissionId"), rootPermission.get("id")));
        
        criteriaQuery.where(predicates.toArray(Predicate[]::new));
        
        Query query = s.createQuery(criteriaQuery);
        return query.getResultList();
    }
    
    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        User u = (User) q.getSingleResult();
        return u;
    }
    
    @Override
    public Role getUserRoleByUserId(int id) {
        Session s = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root rootUser = criteriaQuery.from(User.class);
        Root rootRole = criteriaQuery.from(Role.class);
        criteriaQuery.multiselect(
                rootRole.get("id"),
                rootRole.get("role")
        );
        criteriaQuery.where(criteriaBuilder.equal(rootUser.get("roleId"), rootRole.get("id")));
        Query query = s.createQuery(criteriaQuery);
        Role r = (Role) query.getSingleResult();
        return r;
    }
    
    @Override
    public boolean login(String usernameOrEmail, String password) {
        Session s = sessionFactory.getCurrentSession();
        User user = null;
        
        if (!checkUserAndMail(usernameOrEmail)) {
            return false;
        }
        
        Query query = s.createQuery("FROM User WHERE username = :input OR email = :input", User.class);
        query.setParameter("input", usernameOrEmail);
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean register(User user) {
        if (checkUserAndMail(user.getUsername()) || checkUserAndMail(user.getEmail())) {
            return false;
        }
        user.setBirth(new Date());
        Session s = this.sessionFactory.getCurrentSession();
        s.save(user);
        return true;
    }
    
    @Override
    public boolean checkUserAndMail(String input) {
        try {
            Session s = sessionFactory.getCurrentSession();
            Query query = s.createQuery("SELECT COUNT(*) FROM User WHERE username = :input OR email = :input", Long.class);
            query.setParameter("input", input);
            long count = (Long) query.getSingleResult();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }
    
    @Override
    public boolean updateUserInfo(String username) {
        try {
            Session s = sessionFactory.getCurrentSession();
            User user = s.get(User.class, username);
            if (user.getUsername()!= null) {
                s.update(user);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
