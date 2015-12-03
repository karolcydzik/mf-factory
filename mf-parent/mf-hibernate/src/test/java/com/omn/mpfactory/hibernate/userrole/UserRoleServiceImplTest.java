package com.omn.mpfactory.hibernate.userrole;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.user.UserServiceImpl;
import com.omn.mpfactory.hibernate.user.UserUtilToTest;
import com.omn.mpfactory.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-hibernate.xml" })
public class UserRoleServiceImplTest {
    
    UserUtilToTest util = new UserUtilToTest();

    @Autowired
    UserServiceImpl serviceUser;
    
    @Autowired
    UserRoleServiceImpl serviceRole;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testGetRoles() {
     //   fail("Not yet implemented");
    }

    @Ignore
    @Test
    public void testUpdateUserRoles() {
        User user = util.getUser();
        serviceUser.createOrUpdate(user);
        assertTrue(user.getId()>0);
        user.setUserRoles(util.getUserRoles());
        serviceRole.updateUserRoles(user.getId(), user.getUserRoles());
        user.setUserRoles(util.getUserRoles());
//        fail("Not yet implemented");
    }

}
