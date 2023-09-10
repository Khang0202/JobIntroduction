/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Apply;
import com.oujava.pojo.User;
import com.oujava.repository.ApplyRepository;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trann
 */
@Repository
@Transactional
public class ApplyRepositoryImpl implements ApplyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean addApply(int candidateId, int employerId) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Apply apply = new Apply();

            User candidate = session.get(User.class, candidateId);
            User employer = session.get(User.class, employerId);

            if (candidate == null || employer == null) {

                return false;
            }

            apply.setCandidateId(candidate);
            apply.setEmployerId(employer);
            apply.setCreatedDate(new Date());

            session.save(apply);

            session.getTransaction().commit();

            return true;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();

            return false;
        } finally {
            session.close();
        }
    }

}
