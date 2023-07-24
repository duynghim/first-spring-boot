package com.example.springtodo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class EmployeeDTO {
  private long id;
  private String firstName;
  private String lastName;
  private String emailId;
  private CompanyDTO companyDTO;
}
