package com.wsiiz.repairshop.enterprise.domain.employee;

import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import com.wsiiz.repairshop.servicing.domain.service.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class Employee extends BaseEntity {
    String nameEmployee;
    String surnameEmployee;
    @Enumerated(EnumType.STRING)
    EmployeeType employeeType;
    LocalDate dateOfEmployee;
    Integer branch_ID;
}
