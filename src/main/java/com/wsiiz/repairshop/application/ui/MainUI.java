package com.wsiiz.repairshop.application.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.wsiiz.repairshop.foundation.ui.i18n.I18nAware;
import com.wsiiz.repairshop.servicing.ui.service.ServiceView;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

@SpringUI
@Theme("repairshop")
public class MainUI extends UI implements I18nAware {

  MainViewDisplay mainContent;

  public MainUI(MainViewDisplay mainContent, SpringNavigator navigator) {
    this.mainContent = mainContent;
    navigator.setErrorView(ServiceView.class);
  }

  @Override
  protected void init(VaadinRequest request) {

    setContent(
        new MHorizontalLayout()
            .add(createNavigationBar())
            .expand(mainContent)
            .withFullHeight()
    );
  }

  private Component createNavigationBar() {
    MVerticalLayout m = new MVerticalLayout().withWidth("150px").withStyleName("main-menu");
    m.addComponent(createNavButton(i18n("service"), "service"));
    m.addComponent(createNavButton(i18n("customer"), "customer"));
    return m;
  }

  private Component createNavButton(String caption, String path) {
    Button button = new Button(caption);
    button.addClickListener(e -> getNavigator().navigateTo(path));
    button.addStyleName("main-menu-option");
    button.addStyleName("main-menu-option-" + path);
    return button;
  }


}
