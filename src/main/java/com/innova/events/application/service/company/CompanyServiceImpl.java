package com.innova.events.application.service.company;

import com.innova.events.application.mapper.CompanyMapper;
import com.innova.events.domain.dto.CompanyDTO;
import com.innova.events.infrastructure.persistence.entity.CompanyEntity;
import com.innova.events.infrastructure.persistence.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toCompanyDTOs(companyRepository.findAll());
    }

    @Override
    public CompanyDTO findById(Long id) {
        return companyRepository.findById(id)
                .map(companyMapper::toCompanyDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found"));
    }

    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        CompanyEntity companyEntity = companyMapper.toCompanyEntity(companyDTO);
        CompanyEntity savedEvent = companyRepository.save(companyEntity);
        return companyMapper.toCompanyDTO(savedEvent);
    }

    @Override
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}