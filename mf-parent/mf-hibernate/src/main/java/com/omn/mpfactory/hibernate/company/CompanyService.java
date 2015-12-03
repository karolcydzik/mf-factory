package com.omn.mpfactory.hibernate.company;

import java.util.List;

import com.omn.mpfactory.model.Company;


public interface CompanyService {

    void createOrUpdate(Company company);

    Company findById(Long id);

    List<Company> findAll();

}
