package com.example.demo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("admin")
@PageTitle("BitNae888")
public class AdminView extends VerticalLayout{
    H1 title = new H1("BitNae888");

    public AdminView(){
        
    }
}
