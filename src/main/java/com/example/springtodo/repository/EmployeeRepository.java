package com.example.springtodo.repository;

import com.example.springtodo.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  @Query(
      "SELECT e FROM EmployeeEntity e WHERE LOWER(e.emailId) LIKE LOWER(CONCAT('%', :email, '%'))")
  List<EmployeeEntity> findByEmailContainingIgnoreCase(String email);

  List<EmployeeEntity> findByCompanyEntityId(Long companyId);
}
