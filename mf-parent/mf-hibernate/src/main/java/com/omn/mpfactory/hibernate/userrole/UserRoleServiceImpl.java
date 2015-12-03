package com.omn.mpfactory.hibernate.userrole;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.model.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleDao userRoleDao;
    
    @Override
    public List<UserRole> getRoles(long userId) {
        return userRoleDao.getRoles(userId);
    }

    @Override
    public void updateUserRoles(long userId, List<UserRole> userRoles) {
        
        userRoleDao.updateUserRoles(userId, userRoles);
        
    }

}
