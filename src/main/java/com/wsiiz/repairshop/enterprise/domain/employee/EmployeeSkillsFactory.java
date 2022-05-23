package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.AbstractFactory;

public class EmployeeSkillsFactory implements AbstractFactory<Employee> {
    @Override
    public Employee create() {
        return new EmployeeSkills();
    }
}
