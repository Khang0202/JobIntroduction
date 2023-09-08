/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Faculty;
import com.oujava.repository.FacultyRepository;
import java.util.List;
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
public class FacultyRepositoryImpl implements FacultyRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Faculty> getAllFacultys() {
        Session session = sessionFactory.getCurrentSession();
        try {
            Query q = session.createNamedQuery("Faculty.findAll");
            return q.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addOrUpdateFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (faculty.getId() == null) {
                session.save(faculty);
            } else {
                session.update(faculty);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteFacultyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (session.load(Faculty.class, id) != null) {
                session.delete(session.load(Faculty.class, id));
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

}
