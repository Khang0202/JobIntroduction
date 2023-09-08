/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Rating;
import com.oujava.pojo.User;
import com.oujava.repository.RatingRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class RatingRepositoryImpl implements RatingRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Rating> getRatingOfCusId(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            User exitinguser = session.get(User.class, id);
            if (exitinguser != null) {
                CriteriaBuilder b = session.getCriteriaBuilder();
                CriteriaQuery<Rating> criteriaQuery = b.createQuery(Rating.class);
                Root rootRating = criteriaQuery.from(Rating.class);
                criteriaQuery.select(rootRating);
                criteriaQuery.where(b.equal(rootRating.get("employerId"), exitinguser.getId()));
                criteriaQuery.orderBy(b.desc(rootRating.get("id")));
                Query query = session.createQuery(criteriaQuery);
                List<Rating> ratlist = query.getResultList();
                for (Rating j : ratlist) {
                    j.setPoster(j.getEmployerId().getFirstName());
                }
                return ratlist;
            } else {
                return null;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Boolean addOrUpdateRating(Rating rating) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (rating.getId() == null) {
                session.save(rating);
            } else {
                session.update(rating);
            }
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteRatingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            if (session.load(Rating.class, id) != null) {
                session.delete(session.load(Rating.class, id));
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
