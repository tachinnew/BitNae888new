package com.vaadin.demo.component.login;

import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("BitNae888")
public class LoginPage extends Div {

    private LoginOverlay loginOverlay = new LoginOverlay();

    public String userName;

    public LoginPage() {
        loginOverlay.setTitle("BitNae888");
        loginOverlay.setDescription("This is not actualy an gambling website");
        loginOverlay.setOpened(true);
        loginOverlay.getElement().setAttribute("no-autofocus", "");

        add(loginOverlay);
        
        loginOverlay.addLoginListener(event ->{
            if("user".equals(event.getUsername())){
                if("111".equals(event.getPassword())){
                    UI.getCurrent().navigate("userView");
                    Notification.show("Welcome to BitNae888");
                    return;
                }
            } 
            else if ("admin".equals(event.getUsername())){
                if("111".equals(event.getPassword())){
                    UI.getCurrent().navigate("admin");
                    Notification.show("Welcome admin");
                    return;
               } 
            }

            Notification.show("Wrong Id or Password boi!");

        });

        loginOverlay.addForgotPasswordListener(event ->{
            UI.getCurrent().navigate("ForgotPassword");
        });
    }

}