package com.company;

public class PartTimeEmployee extends Employee {
    private double payPerHour;
    private int hoursWorked;
    Transport t = new Transport();
    Food f = new Food();
    TooMuchSalaryException e = new TooMuchSalaryException();
    public PartTimeEmployee() {

    }

    public PartTimeEmployee(String firstName, String lastName, boolean ifFood, boolean isVeg, boolean ifTransport, int km, double payPerHour, int hoursWorked) {
        super(firstName, lastName, ifFood, isVeg, ifTransport, km);
        this.payPerHour = payPerHour;
        this.hoursWorked = hoursWorked;
    }

    public PartTimeEmployee(String firstName, String lastName, double payPerHour, int hoursWorked) {
        super(firstName, lastName);
        this.payPerHour = payPerHour;
        this.hoursWorked = hoursWorked;
    }

    public PartTimeEmployee(double payPerHour, int hoursWorked) {
        this.payPerHour = payPerHour;
        this.hoursWorked = hoursWorked;
    }

    public double getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(double payPerHour) {
        this.payPerHour = payPerHour;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    //@Override
    public double computeCompensation() throws ExcessDistanceException, TooMuchSalaryException {
        double out=0;

        out+=this.hoursWorked*this.payPerHour;
        e.salaryCheck(out);
        if(this.isIfTransport())
        {
            out-=t.getTransportCost(this.getKm());
        }
        if(this.isIfFood())
        {
            out-=f.getfoodCost(this.isVeg());
        }
        return out;
    }

  //  @Override
    public String createPayStub() throws ExcessDistanceException, TooMuchSalaryException {
        return("          HEARTLAND CARS OF AMERICA        "+
                '\n'+this.getFirstName()+this.getLastName()+
                '\n'+"Hours worked: "+this.getHoursWorked()+
                '\n'+"Pay per hour: "+this.getPayPerHour()+
                '\n'+"Pay: "+"$"+this.computeCompensation()+
                '\n'+"Amount spent on transport: "+"$"+t.getTransportCost(this.getKm())+
                '\n'+"Amount spent on food: "+"$"+f.getfoodCost(this.isVeg()));
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" +
                "payPerHour=" + payPerHour +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}