package com.example.demo.data.game;

import java.util.Random;

import com.example.demo.data.balance.Balance;
import com.example.demo.data.role.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("RockPaperScissorGame")
@PageTitle("BitNae888")
public class RPS extends VerticalLayout{
    private static Random rand = new Random();
    private static int randomNumber = rand.nextInt(3);

    private boolean isWin = false;
    private boolean isDraw = false;

    H1 title = new H1("Rock Paper Scissor Game");
    H2 discribe = new H2("R for Rock / P for Paper / S for Scissor");
    TextField yourChoice = new TextField("Your Choice (R or P or S) : ");
    NumberField betAmount = new NumberField("How much you going to bet this time: ");
    Button letgo = new Button("Let lose all your money");

    public RPS(){
        component();
    }

    private void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        yourChoice.setRequiredIndicatorVisible(true);
        betAmount.setRequiredIndicatorVisible(true);

        mainLayout.addComponentAsFirst(title);
        mainLayout.addComponentAsFirst(discribe);
        mainLayout.addComponentAsFirst(yourChoice); 
        mainLayout.addComponentAsFirst(betAmount);
        mainLayout.addComponentAsFirst(letgo);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);

        letgo.addClickListener(click ->{
            startGame();
            whoWin();
        });
    }

    private void startGame(){

        String bot = getBotRPS();
        String user = yourChoice.getValue();

        if(user.equals("R")){           // Rock Player
            if(bot.equals("R")){
                isDraw = true;
                isWin = false;
            }
            else if(bot.equals("P")){
                isDraw = false;
                isWin = false;
            }
            else if(bot.equals("S")){
                isDraw = false;
                isWin = true;
            }
        }
        else if(user.equals("P")){      // Paper Player
            if(bot.equals("R")){
                isDraw = false;
                isWin = true;
            }
            else if(bot.equals("P")){
                isDraw = true;
                isWin = false;
            }
            else if(bot.equals("S")){
                isDraw = false;
                isWin = false;
            }
        }
        else if(user.equals("S")){          // Scissor Player
            if(bot.equals("R")){
                isDraw = false;
                isWin = false;
            }
            else if(bot.equals("P")){
                isDraw = false;
                isWin = true;
            }
            else if(bot.equals("S")){
                isDraw = true;
                isWin = false;
            }
        }
    }

    private void whoWin(){
        if(isDraw){
            Notification.show("User and bot choose the same choice So Draw!!! :P");
            return;
        }
        if(isWin){
            Notification.show("User win bot congrat");
            printOut(calculateAddBet());
            return;
        }
        printOut(calculateDelBet());
        Notification.show("Nice try bet more to get that back bro :P");
    }

    private static int getRand(){
        return RPS.randomNumber;
    }

    private static String getBotRPS(){
        double me = getRand();

        if(me == 0){
            return "R";
        }
        else if(me == 1){
            return "P";
        }
        else if(me == 2){
            return "S";
        }
        else{
            return "";
        }
    }

    private void printOut(double A){
        Notification.show(Double.toString(A));
    }

    private double calculateAddBet(){
        double add = betAmount.getValue()*0.3;
        double result = User.balance + add;
        Balance.addBalance(add);
        return result;
    }

    private double calculateDelBet(){
        double del = betAmount.getValue();
        double result = User.balance - del;
        Balance.delBalance(del);
        return result;
    }
}
