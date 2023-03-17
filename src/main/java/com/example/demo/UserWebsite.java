package com.example.demo;

import com.vaadin.demo.component.applayout.WebView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.demo.Data.*;

@Route("userView")
@PageTitle("BitNae888")
public class UserWebsite extends VerticalLayout{

    public UserWebsite() throws Exception{ 
        if(EnterStatus.getEnterStatus()){
            add(new WebView());
            return;
        }
        throw new Exception("You cann't reach webnsite without login!!");
    }

}
