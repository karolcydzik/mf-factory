package com.omn.mpfactory.jsf.user;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class UserBeanTest {
    
    private static Validator validator;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Ignore
    @Test
    public void testGetPassword() {
        UserBean userBean = new UserBean();
        
        userBean.setEmail("sdfsdfs");
        userBean.setNick("sw");
        userBean.setPassword("ss");
        userBean.setPasswordConfirm("sssss");
        
        Set<ConstraintViolation<UserBean>> constraintViolations =
                validator.validate( userBean );
        
        int valSize = constraintViolations.size();
        assertEquals( 4, valSize );
        
        Iterator<ConstraintViolation<UserBean>> iterator = constraintViolations.iterator();
        
        
    }

}
