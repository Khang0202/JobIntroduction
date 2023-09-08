package com.oujava.pojo;

import com.oujava.pojo.Apply;
import com.oujava.pojo.Faculty;
import com.oujava.pojo.Job;
import com.oujava.pojo.Rating;
import com.oujava.pojo.Role;
import com.oujava.pojo.Skill;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SetAttribute<User, Apply> applySet;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> country;
    public static volatile SingularAttribute<User, String> education;
    public static volatile SingularAttribute<User, Integer> experience;
    public static volatile SetAttribute<User, Rating> ratingSet;
    public static volatile SetAttribute<User, Job> jobSet;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SetAttribute<User, Apply> applySet1;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> image;
    public static volatile SetAttribute<User, Skill> skillSet;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, Role> roleId;
    public static volatile SingularAttribute<User, String> sex;
    public static volatile SingularAttribute<User, String> filecv;
    public static volatile SingularAttribute<User, Date> birth;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SetAttribute<User, Rating> ratingSet1;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, Faculty> facultyId;
    public static volatile SingularAttribute<User, String> curentposition;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> urlinfo;
    public static volatile SingularAttribute<User, String> username;

}