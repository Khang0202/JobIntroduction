package com.oujava.pojo;

import com.oujava.pojo.Job;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-06T10:55:08")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T15:03:24")
>>>>>>> Stashed changes
@StaticMetamodel(EmploymentType.class)
public class EmploymentType_ { 

    public static volatile SingularAttribute<EmploymentType, Integer> id;
    public static volatile SingularAttribute<EmploymentType, String> employment;
    public static volatile SetAttribute<EmploymentType, Job> jobSet;

}