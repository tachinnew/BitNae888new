package com.example.demo.Data.Balance;

public class Balance {

    private double balance;

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void withDraw(double money){
        this.balance -= money;
    }

    public void addBalance(double money){
        this.balance += money;
    }

    public double getBalance(){
        return this.balance;
    }
}
