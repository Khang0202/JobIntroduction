/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;
import com.oujava.pojo.Skill;
import com.oujava.service.SkillService;
import com.oujava.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/skills")
public class ApiSkillController {
    @Autowired
    private SkillService skillService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<String> addSkill(@RequestBody Skill skill) {
        skillService.addSkill(skill);
        return new ResponseEntity<>("Add skill success", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSkill(@PathVariable int id) {
        skillService.deleteSkillById(id);
        return new ResponseEntity<>("Delete skill success", HttpStatus.OK);
    }

    @GetMapping("/getSkillsByUserId/{userId}")
    public ResponseEntity<List<Skill>> getSkillsByUserId(@PathVariable int userId) {
        skillService.getAllSkillByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
