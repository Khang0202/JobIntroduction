/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Skill;

/**
 *
 * @author trann
 */
public interface SkillService {
     void addSkill(Skill skill);
    void deleteSkillById(int id);
    Skill getAllSkillByUserId(int id);
}
