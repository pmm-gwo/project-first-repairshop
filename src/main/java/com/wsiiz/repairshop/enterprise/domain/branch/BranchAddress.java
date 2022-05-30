package com.wsiiz.repairshop.enterprise.domain.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchAddress {

    private String localityBranch;
    private String streetBranch;
    private String apartmentNoBranch;
    private String postalCodeBranch;
}