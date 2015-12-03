package com.omn.mpfactory.restfull.user;

import java.util.List;

import com.omn.mpfactory.model.User;
import com.omn.mpfactory.transport.city.UserType;

public interface UserFacade {
	
	int confirmUserByConfirmationString(String confirmationString);

	boolean isNick(String nick);

	boolean isEmail(String email);

	void createOrUpdate(UserType user);
	
	List<User> findAll();

}
