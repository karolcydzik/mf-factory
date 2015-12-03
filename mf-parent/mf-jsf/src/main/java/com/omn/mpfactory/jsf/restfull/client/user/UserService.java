package com.omn.mpfactory.jsf.restfull.client.user;

import com.omn.mpfactory.transport.user.UserType;

public interface UserService {

	int confirmUserByConfirmationString(String confirmationString);

	boolean isNick(String nick, long id);

	boolean isEmail(String email, long id);

	void createOrUpdate(UserType user);

}
