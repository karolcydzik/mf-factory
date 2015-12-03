package com.omn.mpfactory.restfull.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.user.UserService;
import com.omn.mpfactory.model.User;
import com.omn.mpfactory.transport.city.UserType;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade{
	
	@Autowired
	UserService userService; 

	@Override
    public int confirmUserByConfirmationString(String confirmationString) {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public boolean isNick(String nick) {
		long id = -1L;
		userService.isNick(nick, id);
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public boolean isEmail(String email) {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public void createOrUpdate(UserType user) {
	    // TODO Auto-generated method stub
	  
    }

	@Override
	public List<User> findAll() {
		return userService.findAll();
	}

}
