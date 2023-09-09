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
    public boolean addSkill(Skill skill) {
        try {
            Session s = this.sessionFactory.getCurrentSession();
            if (skill.getId() == null) {
                s.save(skill);
            } else {
                s.update(skill);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSkillById(int id) {
        try {
            Session session = sessionFactory.getCurrentSession();
            Skill skill = session.get(Skill.class, id);

            if (skill != null) {
                Skill existingUserId = session.get(Skill.class, id);

                if (existingUserId != null && skill.getUserid().equals(existingUserId.getUserid())) {
                    session.delete(skill);
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Skill getAllSkillByUserId(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Skill.class, id);
    }

}
