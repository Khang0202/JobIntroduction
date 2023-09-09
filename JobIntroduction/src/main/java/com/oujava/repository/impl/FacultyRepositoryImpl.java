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
        Session s = sessionFactory.getCurrentSession();
        try {
            Query q = s.createNamedQuery("Faculty.findAll");
            return q.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addOrUpdateFaculty(Faculty faculty) {
        Session s = sessionFactory.getCurrentSession();
        try {
            if (faculty.getId() == null) {
                s.save(faculty);
            } else {
                s.update(faculty);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFacultyById(int id) {
        Session s = sessionFactory.getCurrentSession();
        try {
            if (s.load(Faculty.class, id) != null) {
                s.delete(s.load(Faculty.class, id));
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
