/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Job;
import java.util.List;
import java.util.Map;

/**
 *
 * @author trann
 */
public interface JobService {

    List<Job> getAllJobs();
    Long countJob();
    List<Job> getJobs(Map<String, String> params);
    Job getJobById(int id);
    void addJob(Job job);

    void editJobById(int id, Job updatedJob);

    void deleteJobById(int id);
}
