package com.example.springtodo.mapper;

import com.example.springtodo.dto.EmployeeDTO;
import com.example.springtodo.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

  private final ModelMapper modelMapper;
  private final CompanyMapper companyMapper; // Add CompanyMapper

  public EmployeeMapper(ModelMapper modelMapper, CompanyMapper companyMapper) {
    this.modelMapper = modelMapper;
    this.companyMapper = companyMapper;
  }

  public EmployeeDTO toDTO(EmployeeEntity employeeEntity) {
    EmployeeDTO employeeDTO = modelMapper.map(employeeEntity, EmployeeDTO.class);
    // Map the companyDTO separately using CompanyMapper
    employeeDTO.setCompanyDTO(companyMapper.toDTO(employeeEntity.getCompanyEntity()));
    return employeeDTO;
  }

  public EmployeeEntity toEntity(EmployeeDTO employeeDTO) {
    EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
    // Map the companyEntity separately using CompanyMapper
    employeeEntity.setCompanyEntity(companyMapper.toEntity(employeeDTO.getCompanyDTO()));
    return employeeEntity;
  }
}
