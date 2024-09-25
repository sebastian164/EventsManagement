package com.innova.events.application.service.company;

import com.innova.events.domain.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> findAll();
    CompanyDTO findById(Long id);
    CompanyDTO save(CompanyDTO companyDTO);
    void delete(Long id);
}
