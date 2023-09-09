/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Skill;
import com.oujava.service.SkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @PostMapping("/addSkill")
    @CrossOrigin
    public ResponseEntity<String> addSkill(@RequestBody Skill skill) {
        try {
            if (skillService.addSkill(skill)) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable int id) {
        this.skillService.deleteSkillById(id);

    }

    @GetMapping("/getSkillsByUserId/{userId}")
    @CrossOrigin
    public ResponseEntity<List<Skill>> getSkillsByUserId(@PathVariable int userId) {
        skillService.getAllSkillByUserId(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
