package com.omn.mpfactory.hibernate.companyhist;

import org.springframework.stereotype.Repository;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.CompanyHist;

@Repository
public class CompanyHistDaoImpl extends GenericDaoImpl<CompanyHist> implements CompanyHistDao{
    
    public CompanyHistDaoImpl() {
        super(CompanyHist.class);
    }

}
