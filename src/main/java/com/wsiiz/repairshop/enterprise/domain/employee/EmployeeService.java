package com.wsiiz.repairshop.enterprise.domain.employee;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public List<Employee> getAllByBranchId(Long branchId) {
        return employeeRepository.findAllByBranchId(branchId);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for Id:" + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void removeEmployeeById(Long id) {

        employeeRepository.deleteById(id);
    }
}
