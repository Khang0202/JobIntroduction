/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service.impl;

import com.oujava.pojo.Job;
import com.oujava.repository.EmploymentTypeRepository;
import com.oujava.repository.JobRepository;
import com.oujava.service.JobService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author trann
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepo;
    @Autowired
    private EmploymentTypeRepository employmentTypeRepository;

    @Override
    public List<Job> getAllJobs() {
        return this.jobRepo.getAllJobs();
    }

    @Override
    public boolean deleteJobById(int id) {
        return this.jobRepo.deleteJobById(id);
    }

    @Override
    public Long countJob() {
        return this.jobRepo.countJob();
    }

    @Override
    public List<Job> getJobs(Map<String, String> params) {
        return this.jobRepo.getJobs(params);
    }

    @Override
    public Job getJobById(int id) {
        return this.jobRepo.getJobById(id);
    }

    @Override
    public boolean addOrUpdateJob(Job job) {
        return this.jobRepo.addOrUpdateJob(job);
    }

}
