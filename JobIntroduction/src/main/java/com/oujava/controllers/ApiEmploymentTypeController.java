/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.EmploymentType;
import com.oujava.service.EmploymentTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<EmploymentType> getAllEmploymentTypes() {
        return employmentTypeService.getAllEmType();
    }

    @PostMapping("/addEmploymentType")
    @CrossOrigin
    public void addEmploymentType(@RequestBody EmploymentType employmentType) {
        employmentTypeService.addEmType(employmentType);
    }

    @PutMapping("editEmploymentTyoeById/{id}")
    @CrossOrigin
    public void editEmploymentType(@PathVariable int id, @RequestBody String updatedEmploymentType) {
        employmentTypeService.editEmTypeById(id, updatedEmploymentType);
    }

    @DeleteMapping("deleteEmTypeById/{id}")
    @CrossOrigin
    public void deleteEmploymentType(@PathVariable int id) {
        employmentTypeService.deleteEmTypeById(id);
    }
}