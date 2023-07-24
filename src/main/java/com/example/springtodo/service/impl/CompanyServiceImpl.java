package com.example.springtodo.service.impl;

import com.example.springtodo.dto.CompanyDTO;
import com.example.springtodo.dto.EmployeeDTO;
import com.example.springtodo.entity.CompanyEntity;
import com.example.springtodo.entity.EmployeeEntity;
import com.example.springtodo.exception.ResourceNotFoundException;
import com.example.springtodo.mapper.CompanyMapper;
import com.example.springtodo.mapper.EmployeeMapper;
import com.example.springtodo.repository.CompanyRepository;
import com.example.springtodo.repository.EmployeeRepository;
import com.example.springtodo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

  private final CompanyRepository companyRepository;
  private final EmployeeRepository employeeRepository;
  private final CompanyMapper companyMapper;
  private final EmployeeMapper employeeMapper;

  @Autowired
  public CompanyServiceImpl(
      CompanyRepository companyRepository,
      EmployeeRepository employeeRepository,
      CompanyMapper companyMapper,
      EmployeeMapper employeeMapper) {
    this.companyRepository = companyRepository;
    this.employeeRepository = employeeRepository;
    this.companyMapper = companyMapper;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public List<CompanyDTO> getAllCompany() {
    List<CompanyEntity> companies = companyRepository.findAll();
    return companies.stream().map(companyMapper::toDTO).collect(Collectors.toList());
  }

  @Override
  public CompanyDTO getCompanyById(Long id) {
    CompanyEntity company =
        companyRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + id));
    return companyMapper.toDTO(company);
  }

  @Override
  public CompanyDTO createCompany(CompanyDTO companyDTO) {
    CompanyEntity company = companyMapper.toEntity(companyDTO);
    CompanyEntity savedCompany = companyRepository.save(company);
    return companyMapper.toDTO(savedCompany);
  }

  @Override
  public CompanyDTO updateCompany(Long id, CompanyDTO companyDTO) {
    CompanyEntity company =
        companyRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Company not found with ID: " + id));

    company.setName(companyDTO.getName());
    CompanyEntity updatedCompany = companyRepository.save(company);
    return companyMapper.toDTO(updatedCompany);
  }

  @Override
  public void deleteCompany(Long id) {
    companyRepository.deleteById(id);
  }

  @Override
  public List<EmployeeDTO> getEmployeesByCompanyId(long id) {
    List<EmployeeEntity> employees = employeeRepository.findByCompanyEntityId(id);
    return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
  }
}
