/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Rating;
import com.oujava.repository.RatingRepository;
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
public class RatingRepositoryImpl implements RatingRepository{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Rating> getAllRating() {
        Session session = sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("Rating.findAll");
        
        return q.getResultList();
    }

    @Override
    public void deleteRatingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Rating rating = session.get(Rating.class, id);
        if (rating != null) {
            session.delete(rating);
        }
        else{}
    }
    
}
