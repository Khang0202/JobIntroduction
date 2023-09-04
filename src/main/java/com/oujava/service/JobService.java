/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.service;

import com.oujava.pojo.Job;
import java.util.List;

/**
 *
 * @author trann
 */
public interface JobService {

    List<Job> getAllJobs();

    void addJob(Job job);

    void editJobById(int id, Job updatedJob);

    void deleteJobById(int id);
}
