package com.practice.departmentservice.service;

import com.practice.departmentservice.dto.DepartmentDto;
import com.practice.departmentservice.entity.Department;
import com.practice.departmentservice.repository.DepartmentRepository;

import java.util.List;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(DepartmentDto departmentDto, long id);

    DepartmentDto getDepartmentById(long id);

    List<DepartmentDto> getAllDepartments();

    void deleteDepartmentById(long id);

    void deleteAll();

    DepartmentDto getDepartmentByDepartmentCode(String departmentCode);


}
