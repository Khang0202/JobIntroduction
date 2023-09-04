/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import static com.oujava.format.GetDate.getCurrentDate;
import com.oujava.pojo.Job;
import com.oujava.repository.JobRepository;
import com.oujava.service.JobService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class JobServiceImpl implements JobService{
    @Autowired
    private JobRepository jobRepo;
    
    @Override
    public List<Job> getAllJobs() {
        return jobRepo.getAllJobs();
    }
    
    @Override
    public void addJob(Job job) {
       String currentDate = getCurrentDate();
        job.setDatePosted(currentDate);
        jobRepo.addJob(job);
    }

    @Override
    public void editJobById(int id, Job updatedJob) {
    jobRepo.editJobById(id, updatedJob);
    
}

    @Override
    public void deleteJobById(int id) {
        jobRepo.deleteJobById(id);
    }
    
  
}