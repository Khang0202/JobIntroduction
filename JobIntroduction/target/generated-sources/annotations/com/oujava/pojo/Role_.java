package com.oujava.pojo;

import com.oujava.pojo.RolePermission;
import com.oujava.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T22:32:14")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile SetAttribute<Role, RolePermission> rolePermissionSet;
    public static volatile SingularAttribute<Role, String> role;
    public static volatile SingularAttribute<Role, Integer> id;
    public static volatile SetAttribute<Role, User> userSet;

}