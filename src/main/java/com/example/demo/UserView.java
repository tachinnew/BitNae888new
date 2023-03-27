package com.example.demo;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class UserView extends VerticalLayout{
    H1 name = new H1("name");
    
    public UserView(){
        add(name);
    }

}
