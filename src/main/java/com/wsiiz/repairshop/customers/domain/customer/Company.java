package com.wsiiz.repairshop.customers.domain.customer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@NoArgsConstructor
@DiscriminatorValue("COMPANY")
public class Company extends Customer {

  String name;

  @Enumerated(value = EnumType.STRING)
  ActivityType activityType;

  @Override
  public String fullName() {
    return name;
  }
}
