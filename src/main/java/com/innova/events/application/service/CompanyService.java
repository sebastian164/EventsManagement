package com.innova.events.application.service;

import com.innova.events.domain.model.Company;
import com.innova.events.domain.repository.CompanyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Flux<Company> findAll() {
        return companyRepository.findAll();
    }

    public Mono<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public Mono<Company> save(Company company) {
        return companyRepository.save(company);
    }

    public Mono<Void> deleteById(Long id) {
        return companyRepository.deleteById(id);
    }
}
