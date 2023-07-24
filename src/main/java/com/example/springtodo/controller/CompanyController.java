package com.example.springtodo.controller;

import com.example.springtodo.dto.CompanyDTO;
import com.example.springtodo.dto.EmployeeDTO;
import com.example.springtodo.service.CompanyService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @GetMapping
  public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
    List<CompanyDTO> companies = companyService.getAllCompany();
    return new ResponseEntity<>(companies, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompanyDTO> getCompanyById(@PathVariable Long id) {
    CompanyDTO company = companyService.getCompanyById(id);
    return new ResponseEntity<>(company, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
    CompanyDTO createdCompany = companyService.createCompany(companyDTO);
    return new ResponseEntity<>(createdCompany, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CompanyDTO> updateCompany(
      @PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
    CompanyDTO updatedCompany = companyService.updateCompany(id, companyDTO);
    return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
    companyService.deleteCompany(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}/employees")
  public ResponseEntity<List<EmployeeDTO>> getEmployeesByCompanyId(@PathVariable Long id) {
    List<EmployeeDTO> employees = companyService.getEmployeesByCompanyId(id);
    return new ResponseEntity<>(employees, HttpStatus.OK);
  }
}
