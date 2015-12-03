package com.omn.mpfactory.jsf.company;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.omn.mpfactory.hibernate.agglomerations.AggloConnectionDaoImpl;
import com.omn.mpfactory.hibernate.company.CompanyService;
import com.omn.mpfactory.model.Company;

@Component("companyBean")
@Scope("session")
public class CompanyBean{
    
    private static Log LOG = LogFactory.getLog(AggloConnectionDaoImpl.class);
    
    private List<Company> companyList;
    private Company company;
    private Boolean editable;
    private int index;
    
    @Autowired
    CompanyService companyService;
    
    public void createOrUpdate(Company company) {
        companyService.createOrUpdate(company);
        this.company = company;
    }
    
    public void updateAction() {
    }

    public String editAction() {
        LOG.info(String.format("Edit action. companyId=[%s]",company.getId()));
        return "EditCompany";
    }

    public void cancelAction() {
    }
    
    public void insertAction() {
    }

    public List<Company> getAllCompanies(){
        if(CollectionUtils.isEmpty(companyList)){
            companyList = companyService.findAll();
        }
        return companyList;
    }

    public Company getCompany() {
        if(company == null){
            company = new Company();
        }
        return company;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
