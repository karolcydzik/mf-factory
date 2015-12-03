package com.omn.mpfactory.hibernate.test.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil {
    
    public static String getUnicString(){
        Date date = new Date();
        SimpleDateFormat ft = 
                new SimpleDateFormat ("yyyy.MM.dd-hh:mm:ss");
        return ft.format(date);
    }

}
