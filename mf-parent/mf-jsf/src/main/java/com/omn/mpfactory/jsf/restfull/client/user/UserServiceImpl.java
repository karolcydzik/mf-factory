package com.omn.mpfactory.jsf.restfull.client.user;

import com.omn.mpfactory.transport.user.UserType;

public class UserServiceImpl implements UserService{

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public int confirmUserByConfirmationString(String confirmationString) {
	    // TODO Auto-generated method stub
	    return 0;
    }

	@Override
    public boolean isNick(String nick, long id) {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public boolean isEmail(String email, long id) {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public void createOrUpdate(UserType user) {
	    // TODO Auto-generated method stub
	    
    }

}
