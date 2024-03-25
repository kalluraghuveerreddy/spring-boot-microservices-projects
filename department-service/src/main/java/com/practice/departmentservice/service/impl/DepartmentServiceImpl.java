package com.practice.departmentservice.service.impl;

import com.practice.departmentservice.dto.DepartmentDto;
import com.practice.departmentservice.entity.Department;
import com.practice.departmentservice.repository.DepartmentRepository;
import com.practice.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository,
                                 ModelMapper modelMapper
    ) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto, long id) {
        return null;
    }

    @Override
    public DepartmentDto getDepartmentById(long id) {
        return null;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return null;
    }

    @Override
    public void deleteDepartmentById(long id) {

    }

    @Override
    public void deleteAll() {

    }
}
