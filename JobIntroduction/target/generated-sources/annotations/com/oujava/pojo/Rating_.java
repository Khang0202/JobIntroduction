package com.oujava.pojo;

import com.oujava.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, User> employerId;
    public static volatile SingularAttribute<Rating, Integer> star;
    public static volatile SingularAttribute<Rating, String> comment;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, User> candidateId;

}