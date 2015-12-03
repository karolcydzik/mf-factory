package com.omn.mpfactory.hibernate.userrole;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.UserRole;

@Repository
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole> implements UserRoleDao {

    public UserRoleDaoImpl() {
        super(UserRole.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<UserRole> getRoles(long userId) {
        Session session = getSessionFactory().getCurrentSession();
        session.buildLockRequest(LockOptions.READ);
        return session.createCriteria(UserRole.class).add(Restrictions.eq("user.id", userId)).list();
    }

    @Override
    @Transactional
    public void updateUserRoles(long userId, List<UserRole> userRoles) {
        List<UserRole> currentRoles = getRoles(userId);
        addRoles(userRoles, currentRoles);
        deleteRoles(userRoles, currentRoles);
    }
    
    private void addRoles(List<UserRole> newRoles, List<UserRole> oldRoles) {
        List<UserRole> rolesToAdd = getRolesToAdd(newRoles, oldRoles);
        for(UserRole ur : rolesToAdd){
            delete(ur);
        }
    }
    
    private void deleteRoles(List<UserRole> newRoles, List<UserRole> oldRoles) {
        List<UserRole> rolesToDelete = getRolesToDelete(newRoles, oldRoles);
        for(UserRole ur : rolesToDelete){
            delete(ur);
        }
    }
    
    private List<UserRole> getRolesToDelete(List<UserRole> newRoles, List<UserRole> oldRoles) {
        List<UserRole> result = new ArrayList<UserRole>();
        for (UserRole oldUserRole : oldRoles) {
            boolean isRole = false;
            for (Iterator<UserRole> iterator = newRoles.iterator(); iterator.hasNext();) {
                UserRole userRole = iterator.next();
                if (userRole.getRole().equals(oldUserRole.getRole())) {
                    isRole = true;
                    break;
                }
            }
            if (!isRole) {
                result.add(oldUserRole);
            }
        }
        return result;
    }

    private List<UserRole> getRolesToAdd(List<UserRole> newRoles, List<UserRole> oldRoles) {
        List<UserRole> result = new ArrayList<UserRole>();
        for (Iterator<UserRole> iterator = newRoles.iterator(); iterator.hasNext();) {
            UserRole userRole = iterator.next();
            boolean isRole = false;
            for (UserRole oldUserRole : oldRoles) {
                if (userRole.getRole().equals(oldUserRole.getRole())) {
                    isRole = true;
                    break;
                }
            }
            if (!isRole) {
                result.add(userRole);
            }
        }
        return result;
    }

}
