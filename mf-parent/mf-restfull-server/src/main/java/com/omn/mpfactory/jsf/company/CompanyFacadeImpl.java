package com.omn.mpfactory.jsf.company;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.omn.mpfactory.hibernate.company.CompanyService;
import com.omn.mpfactory.model.Company;

@Component("companyFacade")
@Scope("globalSession")
public class CompanyFacadeImpl implements CompanyFacade {
    
    private static Log LOG = LogFactory.getLog(CompanyFacadeImpl.class);

    @Autowired
    CompanyService companyService;

    @Override
    public Company findById(Long id) {
        return companyService.findById(id);
    }

    @Override
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @Override
    public void createOrUpdate(Company company) {
        if (company != null && company.getName()!=null) {
            Company comp = translateFromBeanToCompany(company);
            companyService.createOrUpdate(comp);
            company.setId(comp.getId());
        }else{
            LOG.error("Company or Company.Name is null.");
        }
    }
    
    private Company translateFromBeanToCompany(Company cb){
        Company company = new Company();
        company.setCityId(cb.getCityId());
        company.setDistrictId(cb.getDistrictId());
        company.setEmail(cb.getEmail());
        company.setFullName(cb.getFullName());
        company.setId(cb.getId());
        company.setMobile(cb.getMobile());
        company.setName(cb.getMobile());
        company.setPhone(cb.getPhone());
        company.setStreetAndNr(cb.getStreetAndNr());
        company.setTs(cb.getTs());
        company.setWww(cb.getWww());
        return company;
    }

}
