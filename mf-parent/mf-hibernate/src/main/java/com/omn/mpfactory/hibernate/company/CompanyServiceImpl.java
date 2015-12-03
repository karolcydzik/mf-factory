package com.omn.mpfactory.hibernate.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.companyhist.CompanyHistService;
import com.omn.mpfactory.hibernate.counter.CounterDao;
import com.omn.mpfactory.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Autowired
    CompanyHistService companyHistService;

    @Autowired
    CounterDao counterDao;

    @Override
    public void createOrUpdate(Company company) {
        if (company.getId() < 1) {
            company.setId(counterDao.getNexId(Company.class.getName()));
            companyDao.create(company);
        } else {
            companyHistService.copyCompanyToHistory(company.getId());
            companyDao.update(company);
        }
    }

    @Override
    public Company findById(Long id) {
        return companyDao.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

}
