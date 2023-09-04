package com.oujava.pojo;

import com.oujava.pojo.RolePermission;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-04T16:44:30")
@StaticMetamodel(Permission.class)
public class Permission_ { 

    public static volatile CollectionAttribute<Permission, RolePermission> rolePermissionCollection;
    public static volatile SingularAttribute<Permission, String> permission;
    public static volatile SingularAttribute<Permission, Integer> id;

}