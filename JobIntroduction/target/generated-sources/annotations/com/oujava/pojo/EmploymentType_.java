package com.oujava.pojo;

import com.oujava.pojo.Job;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(EmploymentType.class)
public class EmploymentType_ { 

    public static volatile SingularAttribute<EmploymentType, Integer> id;
    public static volatile SingularAttribute<EmploymentType, String> employment;
    public static volatile SetAttribute<EmploymentType, Job> jobSet;

}