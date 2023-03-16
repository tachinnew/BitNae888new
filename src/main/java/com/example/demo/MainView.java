package com.example.demo;

import com.vaadin.demo.component.login.LoginPage;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route("")
@PageTitle("BitNae888")
public class MainView extends VerticalLayout{
    
    public MainView(){ 
        add(new LoginPage());
    }

}
