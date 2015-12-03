package com.omn.mpfactory.hibernate.user;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.agglomerations.AggloConnectionDaoImpl;
import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    private static Log LOG = LogFactory.getLog(AggloConnectionDaoImpl.class);

    public UserDaoImpl() {
        super(User.class);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Boolean isEmail(String email, long id) {
        List<User> list = null;
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.READ);
        list = session.createCriteria(User.class).add(Restrictions.eq("email", email)).add(Restrictions.not(Restrictions.eq("id", id))).list();
        if (CollectionUtils.isEmpty(list)) {
            LOG.debug(String.format("Email has not been found. email=[%s], id=[%s].", email, id));
            return false;
        }
        LOG.debug(String.format("Email has been found. email=[%s], id=[%s], user.id=[%s].", email, id, list.get(0).getId()));
        return true;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public Boolean isNick(String nick, long id) {
        List<User> list = null;
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.READ);
        list = session.createCriteria(User.class).add(Restrictions.eq("nick", nick)).add(Restrictions.not(Restrictions.eq("id", id))).list();
        if (CollectionUtils.isEmpty(list)) {
            LOG.debug(String.format("Nick has not been found. email=[%s], id=[%s].", nick, id));
            return false;
        }
        LOG.debug(String.format("Nick has been found. email=[%s], id=[%s], user.id=[%s].", nick, id, list.get(0).getId()));
        return true;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    @Override
    public User getUserByNickAndPassword(String nick, String password) {
        List<User> list = null;
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.READ);
        list = session.createCriteria(User.class).add(Restrictions.eq("nick", nick)).add(Restrictions.eq("passwordHash", password)).list();
        if (CollectionUtils.isEmpty(list)) {
            LOG.debug(String.format("User has not been found. nick=[%s], password=[%s].", nick, password));
            return null;
        }
        LOG.debug(String.format("Nick has been found. nick=[%s], id=[%s].", nick, list.get(0).getId()));
        return list.get(0);
    }

    @Transactional
    @SuppressWarnings("unchecked")
	@Override
	public User getUserByNickPasswordConfirmationString(String nick,
			String password, String confirmationString) {
        List<User> list = null;
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.READ);
        list = session.createCriteria(User.class)
        		.add(Restrictions.eq("nick", nick))
        		.add(Restrictions.eq("passwordHash", password))
        		.add(Restrictions.eq("confirmationString", confirmationString))
        		.list();
        if (CollectionUtils.isEmpty(list)) {
            LOG.debug(String.format("User has not been found. nick=[%s], password=[%s], confirmationString=[%s].", nick, password, confirmationString));
            return null;
        }
        LOG.debug(String.format("Nick has been found. nick=[%s], id=[%s].", nick, list.get(0).getId()));
        return list.get(0);
	}

}
