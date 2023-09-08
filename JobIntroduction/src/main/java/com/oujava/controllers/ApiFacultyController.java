/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Faculty;
import com.oujava.service.FacultyService;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author trann
 */
@RestController
@RequestMapping("/api/faculty")
public class ApiFacultyController {
    @Autowired
    private FacultyService facultyService;
    
    @GetMapping("/getAllFaculty")
    @CrossOrigin
    public ResponseEntity<List<Faculty>> listFacultys() {
        try {
            return new ResponseEntity<>(facultyService.getAllFacultys(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/addOrUpdateFaculty")
    @CrossOrigin
    public ResponseEntity addOrUpdateFaculty(@RequestBody Faculty faculty) {
        try {
            if (facultyService.addOrUpdateFaculty(faculty) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/deleteFacultyById/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteFacultyById(@PathVariable int id) {
        try {
            if (facultyService.deleteFacultyById(id) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
