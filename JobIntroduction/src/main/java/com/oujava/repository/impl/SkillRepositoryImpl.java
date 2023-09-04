/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.Skill;
import com.oujava.repository.SkillRepository;
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
public class SkillRepositoryImpl implements SkillRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSkill(Skill skill) {
        Session s = this.sessionFactory.getCurrentSession();
        s.persist(skill);
    }

    @Override
    public void deleteSkillById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Skill existingUserId = session.get(Skill.class, id);
        Skill skill = session.get(Skill.class, id);
        if (skill != null) {
            if (skill.getUserid().equals(existingUserId.getUserid())) {
                session.delete(skill);
            }
            else{
            }
        }
        else{
        }
    }

    @Override
    public Skill getAllSkillByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Skill.class, id);
    }

}
