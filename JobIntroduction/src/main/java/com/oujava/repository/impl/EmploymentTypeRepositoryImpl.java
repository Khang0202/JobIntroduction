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
public class EmploymentTypeRepositoryImpl implements EmploymentTypeRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<EmploymentType> getAllEmType() {
        Session session = sessionFactory.getCurrentSession();
        try{
            Query q = session.createNamedQuery("EmploymentType.findAll");
        return q.getResultList();
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addOrUpdateEmType(EmploymentType employmentType) {
        Session s = sessionFactory.getCurrentSession();
        try {
            if (employmentType.getId() == null) {
                s.save(employmentType);
            } else {
                s.update(employmentType);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteEmTypeById(int id) {
        Session s = sessionFactory.getCurrentSession();
        try {
            if (s.load(EmploymentType.class, id) != null) {
                s.delete(s.load(EmploymentType.class, id));
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public EmploymentType getEmTypeByName(String string) {
        Session s = sessionFactory.getCurrentSession();
        Query q = s.createNamedQuery("EmploymentType.findByEmployment", EmploymentType.class);
        q.setParameter("employment", string);
        return (EmploymentType) q.getSingleResult();
    }

    @Override
    public EmploymentType getEmTypeById(int id) {
        Session s = sessionFactory.getCurrentSession();
        Query q = s.createNamedQuery("EmploymentType.findById", EmploymentType.class);
        q.setParameter("id", id);
        return (EmploymentType) q.getSingleResult();
    }
}
