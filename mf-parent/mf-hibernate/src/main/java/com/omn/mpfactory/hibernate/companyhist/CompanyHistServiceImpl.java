package com.omn.mpfactory.hibernate.companyhist;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omn.mpfactory.hibernate.company.CompanyDao;
import com.omn.mpfactory.hibernate.counter.CounterDao;
import com.omn.mpfactory.model.Company;
import com.omn.mpfactory.model.CompanyHist;

@Service
public class CompanyHistServiceImpl implements CompanyHistService{

    @Autowired
    CompanyDao companyDao;

    @Autowired
    CompanyHistDao companyHistDao;
    
    @Autowired
    CounterDao counterDao;
    
    @Override
    public void copyCompanyToHistory(Long id) {
        Company company = companyDao.findById(id);
        if(company==null){
            return;
        }
        CompanyHist companyHist = createHistory(company);
        companyHistDao.create(companyHist);
    }

    private CompanyHist createHistory(Company company) {
        CompanyHist companyHist = new CompanyHist();
        companyHist.setId(counterDao.getNexId(CompanyHist.class.getName()));
        companyHist.setTs(new Date());
        
        companyHist.setCityId(company.getCityId());
        //concider.. this is OK
        companyHist.setCompanyId(company.getId());
        companyHist.setDistrictId(company.getDistrictId());
        companyHist.setEmail(company.getEmail());
        companyHist.setFullName(company.getFullName());
        companyHist.setMobile(company.getMobile());
        companyHist.setName(company.getName());
        companyHist.setPhone(company.getPhone());
        companyHist.setStreetAndNr(company.getStreetAndNr());
        companyHist.setWww(company.getWww());
        
        // TODO Auto-generated method stub
        return null;
    }

}
