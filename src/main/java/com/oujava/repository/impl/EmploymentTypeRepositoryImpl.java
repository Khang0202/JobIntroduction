/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.EmploymentType;
import com.oujava.repository.EmploymentTypeRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class EmploymentTypeRepositoryImpl implements EmploymentTypeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<EmploymentType> getAllEmType() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("EmploymentType.findAll");
        
        return q.getResultList();
    }

    @Override
    public void addEmType(EmploymentType employmentType) {
        Session session = sessionFactory.getCurrentSession();
        session.save(employmentType);
    }

    @Override
    public void editEmTypeById(int id, String updateEmploymentType) {
        Session session = sessionFactory.getCurrentSession();
        EmploymentType existingEmploymentType = session.get(EmploymentType.class, id);
        if (existingEmploymentType != null) {
             existingEmploymentType.setEmployment(updateEmploymentType);
            session.update(existingEmploymentType);
        }
        else{}
    }

    @Override
    public void deleteEmTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        EmploymentType employmentType = session.load(EmploymentType.class, id);
        if (employmentType != null) {
            session.delete(employmentType);
        }
        else{}

    }
}
