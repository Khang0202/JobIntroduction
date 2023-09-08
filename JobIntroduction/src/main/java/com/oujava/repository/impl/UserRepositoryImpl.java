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
<<<<<<< Updated upstream
=======
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
    @Autowired
    private LocalSessionFactoryBean factory;
>>>>>>> Stashed changes

    @Override
    public List<User> getAllUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
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

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void editRoleByUserId(int userId, int roleId) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            Role role = session.get(Role.class, roleId);
            if (role != null) {
                user.setRoleId(role);
                session.update(user);
            } else {

            }
        } else {

        }
    }

    @Override
    public void editActiveByUserId(int userId, boolean active) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, userId);
        if (user != null) {
            user.setActive(active);
            session.update(user);
        } else {
        }
    }

     @Override
    public User login(String usernameOrEmail, String password) {
    Session session = sessionFactory.getCurrentSession();
    User user = null;

    Query query = session.createQuery("FROM User WHERE username = :input OR email = :input", User.class);
    query.setParameter("input", usernameOrEmail);
    try {
        user = (User) query.getSingleResult();
    } catch (NoResultException e) {    
        return null; 
    }
    
    if (user != null && user.getPassword().equals(password)) {
        return user; 
    } else {
        return null; 
    }
}


    @Override
    public void registerCandidate(User user) {
        Session session = sessionFactory.getCurrentSession();
        Role candidateRole = new Role();
        candidateRole.setId(2);
        user.setRoleId(candidateRole);
        session.persist(user);
        
    }

    @Override
    public void registerCustomer(User user) {
        Session session = sessionFactory.getCurrentSession();
        Role candidateRole = new Role();
        candidateRole.setId(1);
        user.setRoleId(candidateRole);
        session.persist(user);
    }

    @Override
    public List<Permission> getAllPermissionById(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
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

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.sessionFactory.getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);

        return (User) q.getSingleResult();
    }

<<<<<<< Updated upstream
    
=======
    @Override
    public Role getUserRoleByUserId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = criteriaBuilder.createQuery(Role.class);
        Root rootUser = criteriaQuery.from(User.class);
        Root rootRole = criteriaQuery.from(Role.class);
        criteriaQuery.multiselect(
                rootRole.get("id"),
                rootRole.get("role")
        );
        criteriaQuery.where(criteriaBuilder.equal(rootUser.get("roleId"), rootRole.get("id")));
        Query query = session.createQuery(criteriaQuery);
        return (Role) query.getSingleResult();
    }

    @Override
    public User login(String usernameOrEmail, String password) {
        Session session = sessionFactory.getCurrentSession();
        User user = null;
        
         if (!checkUserAndMail(usernameOrEmail)) {
        return null; 
    }

        Query query = session.createQuery("FROM User WHERE username = :input OR email = :input", User.class);
        query.setParameter("input", usernameOrEmail);
        try {
            user = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User register(User user) {
         if (checkUserAndMail(user.getUsername()) || checkUserAndMail(user.getEmail())) {
        return null; 
    }
        Session s = this.factory.getObject().getCurrentSession();
        s.save(user);
        return user;
    }

    @Override
    public boolean checkUserAndMail(String input) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT COUNT(*) FROM User WHERE username = :input OR email = :input", Long.class);
        query.setParameter("input", input);
         long count = (Long) query.getSingleResult();
        return count > 0;
    }
>>>>>>> Stashed changes

}
