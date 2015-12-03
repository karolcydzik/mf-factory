package com.omn.mpfactory.model;
// Generated 31-Jan-2015 11:53:22 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.omn.mpfactory.util.model.AbstractEntity;

/**
 * UserRole generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="user_role")
public class UserRole extends AbstractEntity{

     private User user;
     private String role;

    public UserRole() {
    }

	
    public UserRole(long id, User user) {
        setId(id);
        this.user = user;
    }
    public UserRole(long id, User user, String role) {
       setId(id);
       this.user = user;
       this.role = role;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="role", length=100)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
}


