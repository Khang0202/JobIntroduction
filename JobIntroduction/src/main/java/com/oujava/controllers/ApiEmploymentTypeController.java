/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.EmploymentType;
import com.oujava.service.EmploymentTypeService;
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
@RequestMapping("/api/employmentTypes")
public class ApiEmploymentTypeController {

    @Autowired
    private EmploymentTypeService employmentTypeService;

    @GetMapping("/getAllEmploymentType")
    @CrossOrigin
    public ResponseEntity<List<EmploymentType>> getAllEmploymentTypes() {
        try {
            return new ResponseEntity<>(employmentTypeService.getAllEmType(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addOrUpdateEmType")
    @CrossOrigin
    public ResponseEntity addOrUpdateEmType(@RequestBody EmploymentType employmentType) {
        try {
            if (employmentTypeService.addOrUpdateEmType(employmentType) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmTypeById/{id}")
    @CrossOrigin
    public ResponseEntity deleteEmploymentType(@PathVariable int id) {
        try {
            if (employmentTypeService.deleteEmTypeById(id) == true) {
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
