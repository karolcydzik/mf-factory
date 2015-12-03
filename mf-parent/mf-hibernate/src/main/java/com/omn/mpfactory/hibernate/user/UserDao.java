package com.omn.mpfactory.hibernate.user;

import com.omn.mpfactory.hibernate.generic.GenericDao;
import com.omn.mpfactory.model.User;

public interface UserDao extends GenericDao<User>{

    Boolean isEmail(String email, long id);
    Boolean isNick(String nick, long id);
    User getUserByNickAndPassword(String nick, String password);
    User getUserByNickPasswordConfirmationString(String nick, String password, String confirmationString);
    
}