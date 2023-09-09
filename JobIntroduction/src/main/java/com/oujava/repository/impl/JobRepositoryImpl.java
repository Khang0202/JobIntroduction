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
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author trann
 */
@Repository
@Transactional
public class JobRepositoryImpl implements JobRepository {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private Environment env;

@Override
public List<Job> getAllJobs() {
    Session s = this.sessionFactory.getCurrentSession();
    CriteriaBuilder criteriaBuilder = s.getCriteriaBuilder();
    CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
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
    criteriaQuery.orderBy(criteriaBuilder.asc(rootJob.get("id")));

    Query query = s.createQuery(criteriaQuery);
    return query.getResultList();
}


    @Override
    public boolean deleteJobById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Job j = getJobById(id);
        if (j != null) {
            session.delete(j);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Long countJob() {
        Session session = this.sessionFactory.getCurrentSession();
        Query q = session.createNamedQuery("Job.countAll");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Job> getJobs(Map<String, String> params) {
        Session s = this.sessionFactory.getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Job> criteriaQuery = b.createQuery(Job.class);
        Root rootJob = criteriaQuery.from(Job.class);
        criteriaQuery.select(rootJob);
        List<Predicate> predicates = new ArrayList<>();
        if (params != null) {
            String key = params.get("key");
            if (key != null && !key.isEmpty()) {
                predicates.add(b.like(rootJob.get("name"), String.format("%%%s%%", key)));
            }

            String fromSalary = params.get("fromSalary");
            if (fromSalary != null && !fromSalary.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(rootJob.get("salary"), Double.parseDouble(fromSalary)));
            }

            String toSalary = params.get("toSalary");
            if (toSalary != null && !toSalary.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(rootJob.get("price"), Double.parseDouble(toSalary)));
            }

            String emTypeId = params.get("emTypeId");
            if (emTypeId != null && !emTypeId.isEmpty()) {
                predicates.add(b.equal(rootJob.get("employmentTypeId"), Integer.parseInt(emTypeId)));
            }
            criteriaQuery.where(predicates.toArray(Predicate[]::new));
        }
        criteriaQuery.orderBy(b.desc(rootJob.get("id")));

        Query query = s.createQuery(criteriaQuery);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }
        List<Job> jobs = query.getResultList();
        for (Job j : jobs) {
            j.setPosterName(j.getEmployerId().getFirstName());
        }
        return jobs;
    }

    @Override
    public Job getJobById(int id) {
        Session s = sessionFactory.getCurrentSession();
        return s.get(Job.class, id);
    }

    @Override
    public boolean addOrUpdateJob(Job job) {
        Session session = this.sessionFactory.getCurrentSession();

        Job existingJob = session.get(Job.class, job.getId());

        if (existingJob != null) {

            if (existingJob.getEmployerId().equals(job.getEmployerId())) {
                existingJob.setName(job.getName());
                existingJob.setEmploymentTypeId(job.getEmploymentTypeId());
                existingJob.setSalary(job.getSalary());
                existingJob.setDescription(job.getDescription());
                existingJob.setCompany(job.getCompany());
                existingJob.setAddress(job.getAddress());
                existingJob.setPhone(job.getPhone());
                existingJob.setEmailcompany(job.getEmailcompany());
                existingJob.setOtherinfomation(job.getOtherinfomation());

                session.update(existingJob);
                return true;
            } else {

                return false;
            }
        } else {

            session.persist(job);
            return true;
        }
    }

}
