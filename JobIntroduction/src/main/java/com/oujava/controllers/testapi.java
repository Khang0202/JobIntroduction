/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.EmploymentType;
import com.oujava.pojo.Faculty;
import com.oujava.pojo.Rating;
import com.oujava.pojo.Role;
import com.oujava.pojo.User;
import com.oujava.service.EmploymentTypeService;
import com.oujava.service.FacultyService;
import com.oujava.service.RatingService;
import com.oujava.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
 * @author nguye
 */
@RestController
@RequestMapping("/api")
public class testapi {
    @Autowired
    private EmploymentTypeService employmentTypeService;
    
    @Autowired
    private FacultyService facultyService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RatingService ratingService;
    
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
    
    @GetMapping("/rolelist")
    @CrossOrigin
    public ResponseEntity<List<Role>> listRole() {
        try {
            return new ResponseEntity<>(this.roleService.getAllRole(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
//    @GetMapping("/user/{userId}/rating")
//    @CrossOrigin
//    public ResponseEntity<List<Rating>> listrating(@PathVariable (value = "userId") int id) {
//        try {
//            return new ResponseEntity<>(ratingService.getRatingOfCusId(id),HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
    
}
