package com.omn.mpfactory.email;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.omn.mpfactory.hibernate.agglomerations.AggloNameDaoImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:com/omn/mpfactory/email/ApplicationContext-Email.xml"})
public class MailMailTest {
    
    private static Log LOG = LogFactory.getLog(AggloNameDaoImpl.class);
    
    @Autowired
    MailMail mail;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        setEnvProp();
    }

    @Before
    public void setUp() throws Exception {
    }

    @Ignore
    @Test
    public void testSendMail() {
        mail.sendMail("chboar@gmail.com", "karol.cydzik@gmail.com", "Test email.", "Body message.");
        LOG.info("Finisch.");
    }

    private static void setEnvProp(){
        Properties prop = new Properties();
        prop.put("javax.net.ssl.trustStore","c:/Users/Karol/.keytool/cacerts");
        prop.put("javax.net.ssl.trustStorePassword","changeit");
        System.setProperties(prop);
    }
}
