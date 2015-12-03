package com.omn.mpfactory.jsf.company;

import java.util.List;

import com.omn.mpfactory.model.Company;

public interface CompanyFacade {

    Company findById(Long id);
    
    List<Company> findAll();
    
    void createOrUpdate(Company company);
}
