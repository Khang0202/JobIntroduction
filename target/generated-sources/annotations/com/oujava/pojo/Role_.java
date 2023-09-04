package com.oujava.pojo;

import com.oujava.pojo.RolePermission;
import com.oujava.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T16:44:30")
@StaticMetamodel(Role.class)
public class Role_ { 

    public static volatile CollectionAttribute<Role, RolePermission> rolePermissionCollection;
    public static volatile SingularAttribute<Role, String> role;
    public static volatile CollectionAttribute<Role, User> userCollection;
    public static volatile SingularAttribute<Role, Integer> id;

}