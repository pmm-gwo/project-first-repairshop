package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.EmployeeType;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)

public class Branch extends BaseEntity {
    String branchName;
    @Enumerated(EnumType.STRING)
    BranchType branchType;
    Integer branch_ID;


    @Embedded
    BranchAddress addressOfBranch;

}
