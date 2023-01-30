package com.techelevator;

public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String fullName;
    private String department;
    private double annualSalary;
//employeeID
    public int getEmployeeID(){
        return employeeID;
    }
//firstName
    public String getFirstName(){
        return firstName;
    }
//lastName
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
//fullName
    public String getFullName(){
        return lastName+", "+ firstName;
    }
//dept
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
    }
//annualSalary
    public double getAnnualSalary() {
        return annualSalary;
    }


    //constructor
    public Employee(int employeeID, String firstName, String lastName, double annualSalary){
        this.employeeID=employeeID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.annualSalary=annualSalary;
    }
    //method

    public void raiseSalary(double percent) {

    }


}
