/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Faculty;
import com.oujava.repository.FacultyRepository;
import java.util.List;
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
        Query q = session.createNamedQuery("Faculty.findAll");
        
        return q.getResultList();
    }

    @Override
    public void editFacultyById(int id, String updatedFaculty) {
        Session session = sessionFactory.getCurrentSession();
        Faculty existingFaculty = session.get(Faculty.class, id);
        if (existingFaculty != null) {
            existingFaculty.setFaculty(updatedFaculty);
            session.update(existingFaculty);
        }
        else{}
    }

    @Override
    public void deleteFacultyById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, id);
        if (faculty != null) {
            session.delete(faculty);
        }
        else{}

    }

    @Override
    public void addFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(faculty);
    }
}
