package com.example.springtodo.dto;

import com.example.springtodo.entity.EmployeeEntity;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CompanyDTO {
  private long id;
  private String name;
  private List<EmployeeEntity> employeeEntities;
}
