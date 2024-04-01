package com.practice.organizationservice.service;

import com.practice.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

    OrganizationDto createOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationByCode(String organizationCode);
}
