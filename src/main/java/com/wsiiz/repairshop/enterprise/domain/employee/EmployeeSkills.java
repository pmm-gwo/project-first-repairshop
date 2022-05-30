package com.wsiiz.repairshop.enterprise.domain.employee;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor

public class EmployeeSkills extends Employee{

    String skills;
}
