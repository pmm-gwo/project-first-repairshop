package com.wsiiz.repairshop.enterprise.domain.branch;

import com.wsiiz.repairshop.enterprise.domain.employee.Employee;
import com.wsiiz.repairshop.foundation.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)

public class Branch extends BaseEntity {

    @NotNull
    @Size(min = 3)
    private String branchName;

    @Enumerated(EnumType.STRING)
    private BranchType branchType;

    @OneToMany
    private List<Employee> branchEmployees;

    @Embedded
    private BranchAddress branchAddress;

    @ManyToOne
    private Branch parentBranch;
}

