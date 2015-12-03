package com.omn.mpfactory.hibernate.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.test.util.TestUtil;
import com.omn.mpfactory.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:ApplicationContext-hibernate.xml" })
public class UserServiceImplTest {

    private UserUtilToTest util = new UserUtilToTest();
    
    @Autowired
    UserService userService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCreateOrUpdate() {
        String st = TestUtil.getUnicString();

        // test if is nick
        Assert.assertFalse(userService.isNick(st, -1L));
        // test if is email
        Assert.assertFalse(userService.isEmail(st, -1L));

        User user = util.getUser(st);
        userService.createOrUpdate(user);
        Assert.assertNotNull(user.getId());

        // test if is nick
        Assert.assertTrue(userService.isNick(user.getNick(), user.getId()+1));
        // test if is email
        Assert.assertTrue(userService.isEmail(user.getEmail(), user.getId()+1));
        // test if is nick
        Assert.assertFalse(userService.isNick(user.getNick(), user.getId()));
        // test if is email
        Assert.assertFalse(userService.isEmail(user.getEmail(), user.getId()));
    }
    
    @Test
    public void testGetUserByNickAndPassword(){
        String st = TestUtil.getUnicString();
        User user = util.getUser(st);
        userService.createOrUpdate(user);
        Assert.assertNotNull(user.getId());
        User user1 = userService.getUserByNickAndPassword(user.getNick(), user.getPasswordHash());
        Assert.assertNotNull(user1);
    }
    
    @Test
    public void testConfirmUserByConfirmationString(){
        String st = TestUtil.getUnicString();
        User user = util.getUser(st);
        userService.createOrUpdate(user);
        Assert.assertNotNull(user.getId());
        int confirm = userService.confirmUserByConfirmationString(user.getConfirmationString());
        Assert.assertTrue(confirm == 1);
    }
    
}
