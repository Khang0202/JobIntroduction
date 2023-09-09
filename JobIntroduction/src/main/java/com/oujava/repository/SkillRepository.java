/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Skill;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface SkillRepository {
    boolean addSkill(Skill skill);
    boolean deleteSkillById(int id);
    Skill getAllSkillByUserId(int id);
}
