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
    public Boolean addOrUpdateEmType(EmploymentType employmentType) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (employmentType.getId() == null) {
                session.save(employmentType);
            } else {
                session.update(employmentType);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteEmTypeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (session.load(EmploymentType.class, id) != null) {
                session.delete(session.load(EmploymentType.class, id));
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
