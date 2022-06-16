package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Employee {
    private String firstName;
    private String lastName;
    private boolean ifFood;
    private boolean isVeg;
    private boolean ifTransport;
    private int km;



    public Employee(String firstName, String lastName, boolean ifFood,boolean isVeg, boolean ifTransport,int km) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ifFood = ifFood;
        this.isVeg=isVeg;
        this.ifTransport = ifTransport;
        this.km=km;
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee()
    {

    }

    public boolean isIfFood() {
        return ifFood;
    }

    public void setIfFood(boolean ifFood) {
        this.ifFood = ifFood;
    }

    public boolean isIfTransport() {
        return ifTransport;
    }

    public void setIfTransport(boolean ifTransport) {
        this.ifTransport = ifTransport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isVeg() {
        return isVeg;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setVeg(boolean veg) {
        isVeg = veg;
    }



        public abstract double computeCompensation() throws TooMuchSalaryException, ExcessDistanceException;
        public abstract String  createPayStub() throws TooMuchSalaryException, ExcessDistanceException;
//    public double getFoodCost()
//    {
//        double cost=0;
//
//            if(this.isVeg)
//            {
//                cost= Employee.veg_cost;
//            }
//            else
//            {
//                cost=Employee.nonveg_cost;
//
//            }
//
//
//        return cost;
//    }

    public int getKm() {
        return km;
    }


   
	
   

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ifFood=" + ifFood +
                ", ifTransport=" + ifTransport +
                '}';
    }
}