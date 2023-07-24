package com.example.springtodo.controller;

import com.example.springtodo.dto.EmployeeDTO;
import com.example.springtodo.service.EmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
    List<EmployeeDTO> employees = employeeService.getAllEmployees();
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
    EmployeeDTO employee = employeeService.getEmployeeById(id);
    return new ResponseEntity<>(employee, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
    EmployeeDTO createdEmployee = employeeService.createEmployee(employeeDTO);
    return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
  }

  @GetMapping("/search")
  public ResponseEntity<List<EmployeeDTO>> searchEmployeesByEmail(@RequestParam String email) {
    List<EmployeeDTO> employees = employeeService.searchEmployeeByEmail(email);
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<EmployeeDTO> updateEmployee(
      @PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
    EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
    return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
