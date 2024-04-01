package com.practice.employeeservice.service;

import com.practice.employeeservice.dto.DepartmentDto;
import com.practice.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
@FeignClient(name = "ORGANIZATION-SERVICE")
public interface ApiClientOrganization {

    @GetMapping("api/organization/bycode/{code}")
    OrganizationDto getOrganizationByCode(@PathVariable("code") String organizationCode);
}
