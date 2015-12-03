package com.omn.mpfactory.hibernate.userrole;

import java.util.List;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.model.UserRole;

public interface UserRoleDao extends GenericDao<UserRole>{

    List<UserRole> getRoles(long userId);
    void updateUserRoles(long userId, List<UserRole> userRoles);
    
}
