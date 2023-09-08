package com.oujava.pojo;

import com.oujava.pojo.Permission;
import com.oujava.pojo.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< Updated upstream
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-06T10:55:08")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-08T15:03:24")
>>>>>>> Stashed changes
@StaticMetamodel(RolePermission.class)
public class RolePermission_ { 

    public static volatile SingularAttribute<RolePermission, Permission> permissionId;
    public static volatile SingularAttribute<RolePermission, Role> roleId;
    public static volatile SingularAttribute<RolePermission, Integer> id;

}