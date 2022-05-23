package com.wsiiz.repairshop.enterprise.ui.employee;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.wsiiz.repairshop.customers.domain.customer.Person;
import com.wsiiz.repairshop.customers.domain.customer.PersonFactory;
import com.wsiiz.repairshop.customers.domain.customer.PersonRepository;
import com.wsiiz.repairshop.customers.domain.customer.PersonService;
import com.wsiiz.repairshop.foundation.ui.BaseView;
import org.vaadin.viritin.grid.MGrid;

@SpringComponent
@UIScope
@SpringView
public class EmployeeView extends BaseView<Person> {

  public EmployeeView(PersonFactory personFactory, PersonService personService,
                      PersonRepository personRepository) {
    super(personFactory, personService, personRepository, new EmployeeEditor());
  }

  @Override
  protected void addColumns(MGrid<Person> table) {

    table.addColumn(entity -> entity.getName() + " " + entity.getSurname())
        .setCaption(i18n("customer"));

    table.addColumn(Person::getPesel)
        .setCaption(i18n("identity"));
  }

}
