package com.example.demo;

import com.vaadin.demo.component.applayout.WebView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("userView")
@PageTitle("BitNae888")
public class UserWebsite extends VerticalLayout implements BeforeEnterObserver{

    public UserWebsite(){ 
        add(new WebView());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent arg0) {
        throw new UnsupportedOperationException("Unimplemented method 'beforeEnter'");
    }

}
