package com.example.springtodo.service;

import com.example.springtodo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> searchEmployeeByEmail(String email);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
