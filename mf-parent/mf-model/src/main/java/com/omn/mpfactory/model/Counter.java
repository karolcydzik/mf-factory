package com.omn.mpfactory.model;
// Generated 31-Jan-2015 11:53:22 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.omn.mpfactory.util.model.AbstractEntity;

/**
 * Counter generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="counter"
    , uniqueConstraints = @UniqueConstraint(columnNames="CLASS_NAME") 
)
public class Counter extends AbstractEntity{

     private String className;
     private long lastNumber;

    public Counter() {
    }

    public Counter(long id, String className, long lastNumber) {
       setId(id);
       this.className = className;
       this.lastNumber = lastNumber;
    }
   
    @Column(name="CLASS_NAME", unique=true, nullable=false, length=40)
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }
    
    @Column(name="LAST_NUMBER", nullable=false)
    public long getLastNumber() {
        return this.lastNumber;
    }
    
    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

}

