/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Job;
import com.oujava.service.JobService;
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
@RequestMapping("/api/job")

public class ApiJobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobslist")
    @CrossOrigin
    public ResponseEntity<List<Job>> listJobs() {
        List<Job> job = this.jobService.getAllJobs();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

//    @PutMapping("/addJob")
//    @CrossOrigin
//    public ResponseEntity<String> addJob(@RequestBody Job job) {
//        this.jobService.addJob(job);
//        return new ResponseEntity<>("Add job success", HttpStatus.OK);
//    }

   @PutMapping("/editJob/{id}")
public ResponseEntity<String> editJobById(@PathVariable int id, @RequestBody Job updatedJob) {
//    String message = jobService.editJobById(id, updatedJob);
//
//    // Kiểm tra thông báo và trả về tương ứng.
//    if ("Update success".equals(message)) {
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    } else if ("You can't edit this job".equals(message)) {
//        return new ResponseEntity<>(message, HttpStatus.UNAUTHORIZED);
//    } else {
//        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
//    }
        this.jobService.editJobById(id, updatedJob);
         return new ResponseEntity<>("Edit success", HttpStatus.OK);
}


    @DeleteMapping("/deleteJob/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable int id) {
        jobService.deleteJobById(id);
        return new ResponseEntity<>("Delete job success", HttpStatus.OK);
    }
}
