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
import org.springframework.web.bind.annotation.PutMapping;
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
        List<Faculty> facultys = facultyService.getAllFacultys();
        return new ResponseEntity<>(facultys, HttpStatus.OK);
    }
    @PutMapping("/editFacultyById/{id}")
    @CrossOrigin
    public ResponseEntity<String> editFacultyById(@PathVariable int id, @RequestBody String updatedFaculty) {
        facultyService.editFacultyById(id, updatedFaculty);
        return new ResponseEntity<>("Edit faculty success", HttpStatus.OK);
    }
    @DeleteMapping("/deleteFacultyById/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteFacultyById(@PathVariable int id) {
        facultyService.deleteFacultyById(id);
        return new ResponseEntity<>("Delete faculty success", HttpStatus.OK);
    }
}
