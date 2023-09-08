/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Job;
import com.oujava.pojo.Rating;
import com.oujava.pojo.User;
import com.oujava.service.RatingService;
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
@RequestMapping("/api/rating")
public class ApiRatingController {
    @Autowired
    private RatingService ratingService;
    
    @PostMapping("/addOrUpdateRating")
    @CrossOrigin
    public ResponseEntity addOrUpdateRating(@RequestBody Rating employmentType) {
        try {
            if (ratingService.addOrUpdateRating(employmentType) == true) {
                return ResponseEntity.ok("{\"result\":\"success\"}");
            } else {
                return ResponseEntity.ok("{\"result\":\"failed\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/deleteRatingById/{id}")
    @CrossOrigin
    public ResponseEntity<String> deleteJobById(@PathVariable int id){
        ratingService.deleteRatingById(id);
        return new ResponseEntity<>("Delete job success", HttpStatus.OK);
    }
}
