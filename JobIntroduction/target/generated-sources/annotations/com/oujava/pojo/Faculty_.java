package com.oujava.pojo;

import com.oujava.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T16:44:30")
@StaticMetamodel(Faculty.class)
public class Faculty_ { 

    public static volatile CollectionAttribute<Faculty, User> userCollection;
    public static volatile SingularAttribute<Faculty, Integer> id;
    public static volatile SingularAttribute<Faculty, String> faculty;

}