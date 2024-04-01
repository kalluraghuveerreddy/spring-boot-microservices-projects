package com.practice.organizationservice.service.impl;

import com.practice.organizationservice.dto.OrganizationDto;
import com.practice.organizationservice.entity.Organization;
import com.practice.organizationservice.repository.OrganizationRepository;
import com.practice.organizationservice.service.OrganizationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;
    private ModelMapper modelMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, ModelMapper modelMapper) {
        this.organizationRepository = organizationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OrganizationDto createOrganization(OrganizationDto organizationDto) {
        Organization organization = organizationRepository.save(modelMapper.map(organizationDto, Organization.class));
        return modelMapper.map(organization, OrganizationDto.class);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String organizationCode) {
        Organization byOrganizationCode = organizationRepository.findByOrganizationCode(organizationCode).get();
        return modelMapper.map(byOrganizationCode, OrganizationDto.class);
    }
}
