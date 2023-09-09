/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Skill;
import com.oujava.repository.SkillRepository;
import com.oujava.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepo;

    @Override
    public boolean addSkill(Skill skill) {
       if(!skill.getSkill().isEmpty()){
           return this.skillRepo.addSkill(skill);
       }
       else return false;
    }

    @Override
    public boolean deleteSkillById(int id) {
        try {
            
            return this.skillRepo.deleteSkillById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Skill getAllSkillByUserId(int id) {
        return this.skillRepo.getAllSkillByUserId(id);
    }

}
