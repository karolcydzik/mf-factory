package com.omn.mpfactory.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.counter.CounterService;
import com.omn.mpfactory.hibernate.user.UserUtilToTest;
import com.omn.mpfactory.model.User;
import com.omn.mpfactory.model.UserRole;
import com.omn.mpfactory.util.model.AbstractEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/hibernate/entity/ApplicationContext-entityDaoTest.xml"})
public class EntityPersistDaoImplTest {
    
    @Autowired
    EntityPersistDao dao;
    
    @Autowired
    CounterService cs;
    
    UserUtilToTest utt = new UserUtilToTest();

    @Test
    public void testCreateListOfT() {
        List<AbstractEntity> bundle = new ArrayList<AbstractEntity>();
        User user = utt.getUser("entUsr");
        user.setId(cs.getNextId(User.class.getName()));
        UserRole userRole1 = utt.getUserRole("Admin");
        userRole1.setUser(user);
        userRole1.setId(cs.getNextId(UserRole.class.getName()));
        UserRole userRole2 = utt.getUserRole("User");
        userRole2.setUser(user);
        userRole2.setId(cs.getNextId(UserRole.class.getName()));
        bundle.add(user);
        bundle.add(userRole1);
        bundle.add(userRole2);
        dao.create(bundle);
    }

}
