package spring.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.ebtity.Company;
import spring.repo.CompanyRepository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class CompanyRepo implements CompanyRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveCompany(Company company) {
        entityManager.persist(company);
        return company.getName();
    }

    @Override
    public Company findCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public String updateCompanyById(Long id, Company newCompany) {
        Company company = findCompanyById(id);
        company.setName(newCompany.getName());
        company.setDescription(newCompany.getDescription());
        company.setAddress(newCompany.getAddress());
        return null;
    }

    @Override
    public List<Company> findAll() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void deleteByOD(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }
}
