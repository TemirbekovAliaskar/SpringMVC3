package spring.service;

import spring.ebtity.Company;

import java.util.List;

public interface CompanyService {
    String saveCompany(Company company);
    Company findCompanyById(Long id);
    String updateCompanyById(Long id,Company newCompany);
    List<Company> findAll();
    void deleteByOD(Long id);
}
