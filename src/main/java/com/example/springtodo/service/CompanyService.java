package com.example.springtodo.service;

import com.example.springtodo.dto.CompanyDTO;
import com.example.springtodo.dto.EmployeeDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllCompany();

    CompanyDTO getCompanyById(Long id);

    CompanyDTO createCompany(CompanyDTO companyDTO);

    CompanyDTO updateCompany(Long id, CompanyDTO companyDTO);

    void deleteCompany(Long id);

    List<EmployeeDTO> getEmployeesByCompanyId(long id);
}
