package com.wsiiz.repairshop.enterprise.domain.branch;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BranchAddress {

    String localityBranch;
    String streetBranch;
    String apartmentNoBranch;
    String postalCodeBranch;
}
