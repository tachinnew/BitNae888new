package com.example.demo;

import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;


@Route("")
public class MainView extends VerticalLayout{
    
    Paragraph text1 = new Paragraph("BitNae888");
    
    public MainView(){      //Main Method
        title();
    }

    public void title(){
        add(text1);
    }


}
