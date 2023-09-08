/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oujava.repository;

import com.oujava.pojo.Job;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nguye
 */
public interface JobRepository{

   List<Job> getAllJobs();
   Long countJob();
   List<Job> getJobs(Map<String, String> params);
   Job getJobById(int id);
   
   void addJob(Job job);
   void editJobById(int id, Job updatedJob); 
   void deleteJobById(int id); 
   
}
