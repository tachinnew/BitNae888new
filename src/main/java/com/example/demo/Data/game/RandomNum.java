package com.example.demo.data.game;

import java.util.Random;

import com.example.demo.data.balance.Balance;
import com.example.demo.data.role.User;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("RandomNumberGame")
@PageTitle("BitNae888")
public class RandomNum extends VerticalLayout{
    private static Random rand = new Random();
    private static int randomNumber = rand.nextInt(10);

    private static boolean isPlayerWin = false;

    private static int getRand(){
        return RandomNum.randomNumber;
    }

    H1 title = new H1("If you can guess num between 0-9");
    H2 number = new H2("0");
    NumberField yourGuess = new NumberField("Your Guess : ");
    NumberField betAmount = new NumberField("How much you going to bet this time: ");
    Button letgo = new Button("Let lose all your money");

    public RandomNum(){
        component();
    }

    private void component(){
        VerticalLayout mainLayout = new VerticalLayout();

        yourGuess.setRequiredIndicatorVisible(true);
        betAmount.setRequiredIndicatorVisible(true);

        mainLayout.addComponentAsFirst(title);
        mainLayout.addComponentAsFirst(number);
        mainLayout.addComponentAsFirst(yourGuess); 
        mainLayout.addComponentAsFirst(betAmount);
        mainLayout.addComponentAsFirst(letgo);

        mainLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(mainLayout);

        letgo.addClickListener(click ->{
            number.setTitle(Integer.toString(RandomNum.getRand()));
            startGame();
            startCalculate();
        });
    }

    private void startGame(){
        isPlayerWin = false;

        double userAnswer = yourGuess.getValue();
        double gameAnswer = getRand();

        if(userAnswer == gameAnswer){
            isPlayerWin = true;
            return;
        }
        isPlayerWin = false;

    }

    private void startCalculate(){
        if(isPlayerWin){
            Notification.show("Congrat You win");
            printOut(calculateAddBet());
            return;
        }
        Notification.show("Nice try bet more an make your answer must easier to correct :P");
        printOut(calculateDelBet());
    }

    private void printOut(double A){
        Notification.show(Double.toString(A));
    }

    private double calculateAddBet(){
        double add = betAmount.getValue()*1;
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