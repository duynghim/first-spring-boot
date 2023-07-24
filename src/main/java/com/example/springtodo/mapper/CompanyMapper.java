package com.example.springtodo.mapper;

import com.example.springtodo.dto.CompanyDTO;
import com.example.springtodo.entity.CompanyEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

  private final ModelMapper modelMapper;

  public CompanyMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public CompanyDTO toDTO(CompanyEntity companyEntity) {
    return modelMapper.map(companyEntity, CompanyDTO.class);
  }

  public CompanyEntity toEntity(CompanyDTO companyDTO) {
    return modelMapper.map(companyDTO, CompanyEntity.class);
  }
}
