package spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.ebtity.Company;
import spring.repo.CompanyRepository;
import spring.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public String saveCompany(Company company) {
        return companyRepository.saveCompany(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findCompanyById(id);
    }

    @Override
    public String updateCompanyById(Long id, Company newCompany) {
        return companyRepository.updateCompanyById(id, newCompany);
    }

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteByOD(Long id) {
        companyRepository.deleteByOD(id);
    }
}
