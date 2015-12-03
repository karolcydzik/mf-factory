package com.omn.mpfactory.hibernate.user;

import java.util.List;

import com.omn.mpfactory.model.User;

public interface UserService {
    
    Boolean isEmail(String email, long id);
    Boolean isNick(String nick, long id);
    void createOrUpdate(User user);
    User getUserByNickAndPassword(String nick, String password);
    int confirmUserByConfirmationString(String confirmationString);
    List<User> findAll();
}
