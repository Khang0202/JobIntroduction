package com.oujava.pojo;

import com.oujava.pojo.Apply;
import com.oujava.pojo.Faculty;
import com.oujava.pojo.Job;
import com.oujava.pojo.Rating;
import com.oujava.pojo.Role;
import com.oujava.pojo.Skill;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T16:44:30")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Job> jobCollection;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> education;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Role> roleId;
    public static volatile SingularAttribute<User, String> filecv;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile CollectionAttribute<User, Rating> ratingCollection1;
    public static volatile SingularAttribute<User, Date> experience;
    public static volatile CollectionAttribute<User, Rating> ratingCollection;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, Faculty> facultyId;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> curentposition;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile CollectionAttribute<User, Apply> applyCollection1;
    public static volatile SingularAttribute<User, String> urlinfo;
    public static volatile CollectionAttribute<User, Skill> skillCollection;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile CollectionAttribute<User, Apply> applyCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}