package com.vaadin.demo.component.applayout;

import com.example.demo.data.role.User;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("UserInfo")
@PageTitle("BitNae888")
public class UserInfoAppLayout extends VerticalLayout{
    H1 title = new H1("BitNae888");

    H2 name = new H2("Name : " + User.getName());

    public UserInfoAppLayout(){
        add(title);
        add(name);
    }
}
