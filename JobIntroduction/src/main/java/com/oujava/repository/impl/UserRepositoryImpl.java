///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.oujava.repository.impl;
//
//import com.oujava.DTO.RegisterDTO;
//import com.oujava.pojo.EmploymentType;
//import com.oujava.pojo.Job;
//import com.oujava.pojo.Permission;
//import com.oujava.pojo.Role;
//import com.oujava.pojo.RolePermission;
//import com.oujava.pojo.User;
//import com.oujava.repository.UserRepository;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// *
// * @author trann
// */
//@Repository
//@Transactional
//public class UserRepositoryImpl implements UserRepository {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public List<User> getAllUsers() {
//        Session session = this.sessionFactory.getCurrentSession();
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
//        Root rootUser = criteriaQuery.from(User.class);
//        Root rootRole = criteriaQuery.from(Role.class);
//        Root rootPermission = criteriaQuery.from(Permission.class);
//        Root rootRolePermission = criteriaQuery.from(RolePermission.class);
//
//        criteriaQuery.multiselect(
//                rootUser.get("first_name"),
//                rootUser.get("last_name"),
//                rootUser.get("email"),
//                rootUser.get("username"),
//                rootRole.get("role"),
//                rootPermission.get("permission"),
//                rootUser.get("active")
//        );
//        List<Predicate> predicates = new ArrayList<>();
//        predicates.add(criteriaBuilder.equal(rootUser.get("roleId"), rootRole.get("id")));
//        predicates.add(criteriaBuilder.equal(rootUser.get("roleId"), rootRolePermission.get("id")));
//        predicates.add(criteriaBuilder.equal(rootRolePermission.get("permissionId"), rootPermission.get("id")));
//
//        criteriaQuery.where(predicates.toArray(Predicate[]::new));
//
//        Query query = session.createQuery(criteriaQuery);
//        return query.getResultList();
//    }
//
//    @Override
//    public void editRoleByUserId(int userId, int roleId) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.get(User.class, userId);
//        if (user != null) {
//            Role role = session.get(Role.class, roleId);
//            if (role != null) {
//                user.setRoleId(role);
//                session.update(user);
//            } else {
//
//            }
//        } else {
//
//        }
//    }
//
//    @Override
//    public void editActiveByUserId(int userId, boolean active) {
//        Session session = sessionFactory.getCurrentSession();
//        User user = session.get(User.class, userId);
//        if (user != null) {
//            user.setActive(active);
//            session.update(user);
//        } else {
//        }
//    }
//
//    @Override
//    public void login(String username, String password) {
//        Session session = sessionFactory.getCurrentSession();
//
//    }
//
//    @Override
//    public User register(RegisterDTO register) {
//        Session session = sessionFactory.getCurrentSession();
//        
//        
//    }
//
//}
