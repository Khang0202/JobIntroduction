/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.controllers;

import com.oujava.pojo.Job;
import com.oujava.service.JobService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author nguye
 */
@Controller
public class JobController {
    @Autowired
    private JobService JobService;
    
    @GetMapping(value = "/job")
    public String list(Model model){
        model.addAttribute("job", new Job());
        return "job";
    }
    @GetMapping(value = "/job/{id}") 
    public String getinfo(Model model, @PathVariable(value = "id") int id){
        model.addAttribute("job", this.JobService.getJobById(id));
        return "job";
    }
    @PutMapping(value = "/job/{id}") 
    public String update(Model model, @PathVariable(value = "id") int id, Job job){
        model.addAttribute("job", this.JobService.getJobById(id));
        this.JobService.editJobById(id, job);
        return "job";
    }
    @PostMapping(value = "/job") 
    public String add(@ModelAttribute Job job){
        System.out.println(job.getEmTypeTemp());
        this.JobService.addJob(job);
        return "job";
    }
    
    
}
