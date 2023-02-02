package com.techelevator;

import java.util.List;

public class BankCustomer implements Accountable{
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts;

    //getters&setters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Accountable> getAccountsCustomer() {
        return accounts;
    }

    //start method


    public void getAccounts(){

        return Accountable;
    }



    public void addAccount(Accountable newAccount){

    }

    @Override
    public int getBalance() {
        return 0;
    }

    //end method
}
