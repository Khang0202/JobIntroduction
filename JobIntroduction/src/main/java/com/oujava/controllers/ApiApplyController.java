/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/apply")
public class ApiApplyController {
    
    @Autowired
    private ApplyService applyService;
    
    
    @GetMapping("/apply/{candidateId}/{employerId}")
    public ResponseEntity<String> addApply(@PathVariable int candidateId, @PathVariable int employerId) {
       
        if (applyService.addApply(candidateId, employerId)) {
             return ResponseEntity.ok("{\"result\":\"success\"}");
        } else {
            return ResponseEntity.ok("{\"result\":\"failed\"}");
        }
    }
}
