package com.oujava.pojo;

import com.oujava.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(Faculty.class)
public class Faculty_ { 

    public static volatile SingularAttribute<Faculty, Integer> id;
    public static volatile SetAttribute<Faculty, User> userSet;
    public static volatile SingularAttribute<Faculty, String> faculty;

}