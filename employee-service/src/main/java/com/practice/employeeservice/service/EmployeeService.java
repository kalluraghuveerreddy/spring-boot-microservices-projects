package com.practice.employeeservice.service;

import com.practice.employeeservice.dto.APIResponseDto;
import com.practice.employeeservice.dto.EmployeeDto;
import com.practice.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();

    APIResponseDto getEmployeeById(long id);
}
