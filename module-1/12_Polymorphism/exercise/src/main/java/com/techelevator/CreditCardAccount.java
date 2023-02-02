package com.techelevator;

public class CreditCardAccount implements Accountable{
    private String accountHolder;
    private String accountNumber;
    private int debt;

    //constructor
    public CreditCardAccount (String accountHolder, String accountNumber){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.debt=0;
    }

    //getters
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getDebt() {
        return debt;
    }
    //method start

    public int pay (int amountToPay){
        debt=debt-amountToPay;
        return debt;   ///do methods need getBalance()??
    }
    public int charge(int amountToCharge){
        debt=debt+amountToCharge;
        return debt;

    }

    @Override
    public int getBalance() {
        int balance=0-debt;

        return balance;

    }

    //method end
}
