package com.omn.mpfactory.hibernate.company;

import org.springframework.stereotype.Repository;

import com.omn.mpfactory.hibernate.generic.GenericDaoImpl;
import com.omn.mpfactory.model.Company;

@Repository
public class CompanyDaoImpl extends GenericDaoImpl<Company> implements CompanyDao {
   
    public CompanyDaoImpl() {
        super(Company.class);
    }
}
