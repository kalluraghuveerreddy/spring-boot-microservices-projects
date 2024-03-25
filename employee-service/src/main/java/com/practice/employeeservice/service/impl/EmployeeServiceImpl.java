package com.practice.employeeservice.service.impl;

import com.practice.employeeservice.dto.APIResponseDto;
import com.practice.employeeservice.dto.DepartmentDto;
import com.practice.employeeservice.dto.EmployeeDto;
import com.practice.employeeservice.entity.Employee;
import com.practice.employeeservice.repository.EmployeeRepository;
import com.practice.employeeservice.service.ApiClient;
import com.practice.employeeservice.service.EmployeeService;
import org.aspectj.asm.IModelFilter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private ApiClient apiClient;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper,
                               ApiClient apiClient
                               //WebClient webClient
                               //RestTemplate restTemplate
    ) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.apiClient=apiClient;
        //this.restTemplate = restTemplate;
        //this.webClient = webClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee savedEmployee = employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream()
                .map((emp -> modelMapper.map(emp, EmployeeDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public APIResponseDto getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).get();
        //using RestTemplate
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"
//        + employee.getDepartmentCode(), DepartmentDto.class);
//         DepartmentDto departmentDto = responseEntity.getBody();

        //Using Webclient
//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
        DepartmentDto departmentDto = apiClient.getDepartmentByDepCode(employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto(modelMapper.map(employee, EmployeeDto.class), departmentDto);
        return apiResponseDto;
    }

}
