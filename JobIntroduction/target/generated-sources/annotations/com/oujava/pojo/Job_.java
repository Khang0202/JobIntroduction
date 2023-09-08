package com.oujava.pojo;

import com.oujava.pojo.EmploymentType;
import com.oujava.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(Job.class)
public class Job_ { 

    public static volatile SingularAttribute<Job, String> emailcompany;
    public static volatile SingularAttribute<Job, User> employerId;
    public static volatile SingularAttribute<Job, String> address;
    public static volatile SingularAttribute<Job, String> phone;
    public static volatile SingularAttribute<Job, EmploymentType> employmentTypeId;
    public static volatile SingularAttribute<Job, String> name;
    public static volatile SingularAttribute<Job, String> description;
    public static volatile SingularAttribute<Job, String> company;
    public static volatile SingularAttribute<Job, Integer> id;
    public static volatile SingularAttribute<Job, Integer> salary;
    public static volatile SingularAttribute<Job, Date> datePosted;
    public static volatile SingularAttribute<Job, String> otherinfomation;

}