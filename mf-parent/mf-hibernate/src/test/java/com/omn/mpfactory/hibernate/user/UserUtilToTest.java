package com.omn.mpfactory.hibernate.user;

import java.util.ArrayList;
import java.util.List;

import com.omn.mpfactory.hibernate.test.util.TestUtil;
import com.omn.mpfactory.model.User;
import com.omn.mpfactory.model.UserRole;

public class UserUtilToTest {
    
    public User getUser(){
        String st = TestUtil.getUnicString();
        return getUser(st);
    }
    
    public User getUser(String st){
        User user = new User();
        user.setEmail(st + "@sss.com");
        user.setNick(st);
        user.setPasswordHash("sssss");
        return user;
    }
    
    public List<UserRole> getUserRoles(){
        List<UserRole> userRoleSet = new ArrayList<UserRole>();
        userRoleSet.add(getUserRole(UserRolesEnum.ADMIN.name()));
        userRoleSet.add(getUserRole(UserRolesEnum.USER.name()));
        return userRoleSet;
    }
    
    public UserRole getUserRole(String role){
        UserRole ur = new UserRole();
        ur.setRole(role);
        return ur;
    }


}
