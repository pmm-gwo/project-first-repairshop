package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class Employee extends BaseEntity {

    private String nameEmployee;
    private String surnameEmployee;
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;
    private LocalDate dateOfHire;
    @OneToMany
    private List<EmployeeSkill> skills;
    Long branchId;
}
