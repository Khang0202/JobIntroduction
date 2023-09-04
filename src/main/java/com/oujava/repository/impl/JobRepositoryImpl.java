/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oujava.repository.impl;

import com.oujava.pojo.EmploymentType;
import com.oujava.pojo.Job;
import com.oujava.pojo.User;
import com.oujava.repository.JobRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.nio.file.AccessDeniedException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trann
 */
@Repository
@Transactional
public class JobRepositoryImpl implements JobRepository{
    
    
   @Autowired
    private SessionFactory sessionFactory;
  
    
   @Override
   public List<Job> getAllJobs() {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
        Root rootJob = criteriaQuery.from(Job.class);
        Root rootEmploymentType = criteriaQuery.from(EmploymentType.class);
        Root rootUser = criteriaQuery.from(User.class);
        
        criteriaQuery.multiselect(
        		rootJob.get("id"), 
        		rootUser.get("firstName"),
        		rootJob.get("name"),
        		rootEmploymentType.get("employment"),
        		rootJob.get("salary"),
        		rootJob.get("description"),
        		rootJob.get("company"),
        		rootJob.get("address"),
        		rootJob.get("phone"),
        		rootJob.get("emailcompany"),
        		rootJob.get("otherinfomation"),
        		rootJob.get("datePosted")
        		);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(rootJob.get("employmentTypeId"), rootEmploymentType.get("id")));
        predicates.add(criteriaBuilder.equal(rootJob.get("employerId"), rootUser.get("id")));
        
        criteriaQuery.where(predicates.toArray(Predicate[]::new));

        Query query = session.createQuery(criteriaQuery);
        return query.getResultList();
    }
    



    @Override
    public void addJob(Job job) {
         Session session = this.sessionFactory.getCurrentSession();
        session.persist(job);
    }

    @Override
    public void editJobById(int id, Job updatedJob)  {
    Session session = this.sessionFactory.getCurrentSession();
    Job existingJob = session.get(Job.class, id);

    if (existingJob != null) {
        if (existingJob.getEmployerId().equals(updatedJob.getEmployerId())) {
            existingJob.setName(updatedJob.getName());
            existingJob.setEmploymentTypeId(updatedJob.getEmploymentTypeId());
            existingJob.setSalary(updatedJob.getSalary());
            existingJob.setDescription(updatedJob.getDescription());
            existingJob.setCompany(updatedJob.getCompany());
            existingJob.setAddress(updatedJob.getAddress());
            existingJob.setPhone(updatedJob.getPhone());
            existingJob.setEmailcompany(updatedJob.getEmailcompany());
            existingJob.setOtherinfomation(updatedJob.getOtherinfomation());
            session.update(existingJob);
          
        } else {
           
        }
    } else {
        
       
    }
       
}

    @Override
    public void deleteJobById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Job existingJob = session.get(Job.class, id);
        if (existingJob != null) {
            session.delete(existingJob);
        }
        else{}
       
    }
}