package com.omn.mpfactory.hibernate.spring.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MpfUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
        UserDetails ud = new User(arg0, arg0, null);
        // TODO Auto-generated method stub
        return null;
    }

}
