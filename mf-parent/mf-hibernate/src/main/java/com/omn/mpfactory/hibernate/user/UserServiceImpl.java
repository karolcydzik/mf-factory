package com.omn.mpfactory.hibernate.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.counter.CounterDao;
import com.omn.mpfactory.model.User;
import com.omn.mpfactory.model.UserRole;
import com.omn.mpfactory.utils.ConfirmationStringHelper;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserDao userDao;
    @Autowired
    CounterDao counterDao;
    @Autowired
    ConfirmationStringHelper confirmationStringHelper; 

    @Override
    public Boolean isEmail(String email, long id) {
        return userDao.isEmail(email, id);
    }

    @Override
    public Boolean isNick(String nick, long id) {
        return userDao.isNick(nick, id);
    }

    @Override
    public void createOrUpdate(User user) {
    	user.setConfirmationString(confirmationStringHelper.getConfirmationString(user.getNick(), user.getEmail(), user.getPasswordHash()));
        if (user.getId() < 1) {
            user.setId(counterDao.getNexId(User.class.getName()));
            updateUserRoles(user);
            userDao.create(user);
        } else {
            updateUserRoles(user);
            userDao.update(user);
        }
    }
    
    private void updateUserRoles(User user){
        for (UserRole ur : user.getUserRoles()) {
            if(ur.getId()<1){
                ur.setId(counterDao.getNexId(UserRole.class.getName()));
            }
            if(ur.getUser()==null){
                ur.setUser(user);
            }
        }
    }

    @Override
    public User getUserByNickAndPassword(String nick, String password) {
        return userDao.getUserByNickAndPassword(nick, password);
    }

	@Override
	public int confirmUserByConfirmationString(String confirmationString) {
		String nick = confirmationStringHelper.getNick(confirmationString);
		String password = confirmationStringHelper.getPassword(confirmationString);
		User user = userDao.getUserByNickPasswordConfirmationString(nick, password, confirmationString);
		if(user==null){
			return -1;
		}
		return 1;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
