package com.example.springtodo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "employees")
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email_id")
  @Email(message = "Invalid email format")
  private String emailId;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private CompanyEntity companyEntity;
}
