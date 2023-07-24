package com.example.springtodo.service.impl;

import com.example.springtodo.dto.EmployeeDTO;
import com.example.springtodo.entity.EmployeeEntity;
import com.example.springtodo.exception.ResourceNotFoundException;
import com.example.springtodo.mapper.EmployeeMapper;
import com.example.springtodo.repository.EmployeeRepository;
import com.example.springtodo.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public List<EmployeeDTO> getAllEmployees() {
    List<EmployeeEntity> employees = employeeRepository.findAll();
    return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
  }

  @Override
  public EmployeeDTO getEmployeeById(Long id) {
    EmployeeEntity employee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + id));
    return employeeMapper.toDTO(employee);
  }

  @Override
  public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
    EmployeeEntity employee = employeeMapper.toEntity(employeeDTO);
    EmployeeEntity savedEmployee = employeeRepository.save(employee);
    return employeeMapper.toDTO(savedEmployee);
  }

  @Override
  public List<EmployeeDTO> searchEmployeeByEmail(String partialEmail) {
    List<EmployeeEntity> employees =
        employeeRepository.findByEmailContainingIgnoreCase(partialEmail);

    if (employees.isEmpty()) {
      throw new ResourceNotFoundException(
          "No employees found with the given email: " + partialEmail);
    }

    return employees.stream().map(employeeMapper::toDTO).collect(Collectors.toList());
  }

  @Override
  public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
    EmployeeEntity employee =
        employeeRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + id));

    // Update the employee details
    employee.setFirstName(employeeDTO.getFirstName());
    employee.setLastName(employeeDTO.getLastName());
    employee.setEmailId(employeeDTO.getEmailId());
    // ... other properties

    EmployeeEntity updatedEmployee = employeeRepository.save(employee);
    return employeeMapper.toDTO(updatedEmployee);
  }

  @Override
  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }
}
