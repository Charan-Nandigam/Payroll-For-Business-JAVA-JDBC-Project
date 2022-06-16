package com.company;

public class FullTimeEmployee extends Employee{
    private double baseSalary;
    private int hoursWorked;
    Transport t = new Transport();
    Food f = new Food();
    TooMuchSalaryException e = new TooMuchSalaryException();
    public FullTimeEmployee() {

    }

    public FullTimeEmployee(String firstName, String lastName, boolean ifFood, boolean isVeg, boolean ifTransport, int km, double baseSalary, int hoursWorked) {
        super(firstName, lastName, ifFood, isVeg, ifTransport, km);
        this.baseSalary=baseSalary;
        this.hoursWorked = hoursWorked;
    }

    public FullTimeEmployee(String firstName, String lastName, double baseSalary, int hoursWorked) {
        super(firstName, lastName);
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
    }

    public FullTimeEmployee(double baseSalary, int hoursWorked) {
        this.baseSalary = baseSalary;
        this.hoursWorked = hoursWorked;
    }



    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {

            this.baseSalary = baseSalary;


    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
  // @Override
   public double computeCompensation() throws TooMuchSalaryException, ExcessDistanceException {
        double out=0;
        double hourlySal= this.getBaseSalary()/80;
        int hours=this.getHoursWorked();



        if(this.isIfTransport())
        {
            out-=t.getTransportCost(this.getKm());
        }
        if(this.isIfFood())
        {
            out-=f.getfoodCost(this.isVeg());

        }
        if(hours<80)
        {
            out+= this.getBaseSalary();
            e.salaryCheck(out);
            return Math.round(out*100.0)/100.0;
        }
        else
        {
            out+=this.getBaseSalary()+((hours-80)*1.5*hourlySal);
            e.salaryCheck(out);
            return Math.round(out*100.0)/100.0;
        }

    }
    //@Override
    public String createPayStub() throws TooMuchSalaryException, ExcessDistanceException {
        /*System.out.println("         HEARTLAND CARS OF AMERICA        ");
        System.out.println(this.getFirstName()+this.getLastName());
        System.out.println("Basic Salary: $" +this.getBaseSalary());
        System.out.println("Hours worked: "+this.getHoursWorked());
        System.out.println("Pay: "+"$"+this.computeCompensation());
        */

        return("          HEARTLAND CARS OF AMERICA        "+
                '\n'+this.getFirstName()+this.getLastName()+
        '\n'+"Basic Salary: $" +this.getBaseSalary()+
        '\n'+"Hours worked: "+this.getHoursWorked()+
        '\n'+"Pay: "+"$"+this.computeCompensation()+
                '\n'+"Amount spent on transport: "+"$"+t.getTransportCost(this.getKm())+
        '\n'+"Amount spent on food: "+"$"+f.getfoodCost(this.isVeg()));


    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "baseSalary=" + baseSalary +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}