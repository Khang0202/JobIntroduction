/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import com.oujava.repository.RoleRepository;
import java.util.List;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trann
 */
@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Role> getAllRole(Map<String, String> params) {
        String s = params.get("userId");
        int userId;
        if (s == null || s.isEmpty()) {
            userId = -1;
        } else {
            userId = Integer.parseInt(s);
        }
        Session session = sessionFactory.getCurrentSession();
        try {
            Query q = session.createNamedQuery("Role.findAll");
            List<Role> roles = q.getResultList();
            if (userId == -1) {
                roles.remove(0);
                return roles;
            } else {
                User exitinguser = session.get(User.class, userId);
                if (exitinguser.getRoleId().getId() != 1) {
                    roles.remove(0);
                    return roles;
                } else {
                    return roles;
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

}
