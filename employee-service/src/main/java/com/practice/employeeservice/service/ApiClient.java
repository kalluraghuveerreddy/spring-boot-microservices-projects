package com.practice.employeeservice.service;

import com.practice.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", name = "DEPARTMENT-SERVICE")
public interface ApiClient {
    @GetMapping("api/departments/{depCode}")
    DepartmentDto getDepartmentByDepCode(@PathVariable("depCode") String departmentCode);
}
