package com.company;

public class SalesEmployee extends Employee {

    private double baseSalary;
    private double salesVolume;
    Transport t = new Transport();
    Food f = new Food();
    TooMuchSalaryException e = new TooMuchSalaryException();


    public SalesEmployee(String firstName, String lastName, boolean ifFood, boolean isVeg, boolean ifTransport, int km, double baseSalary, double salesVolume) {
        super(firstName, lastName, ifFood, isVeg, ifTransport, km);
        this.baseSalary = baseSalary;
        this.salesVolume = salesVolume;
    }

    public SalesEmployee() {

    }

    public SalesEmployee(String firstName, String lastName, double baseSalary, double salesVolume) {
        super(firstName, lastName);
        this.baseSalary = baseSalary;
        this.salesVolume = salesVolume;
    }

    public SalesEmployee(double baseSalary, double salesVolume) {
        this.baseSalary = baseSalary;
        this.salesVolume = salesVolume;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(double salesVolume) {
        this.salesVolume = salesVolume;
    }

   // @Override
    public double computeCompensation() throws ExcessDistanceException{
        double out=0;

        out += this.baseSalary+0.02*this.salesVolume;
        try {
            e.salaryCheck(out);
        }
        catch(TooMuchSalaryException e)
        {
            System.out.println("recheck salary amount");
        }
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
    public String createPayStub() throws ExcessDistanceException{
        return("          HEARTLAND CARS OF AMERICA        "+
                '\n'+this.getFirstName()+this.getLastName()+
                '\n'+"Base Salary: "+this.getBaseSalary()+
                '\n'+"Sales Volume: "+this.getSalesVolume()+
                '\n'+"Pay: "+"$"+this.computeCompensation()+
                '\n'+"Amount spent on transport: "+"$"+t.getTransportCost(this.getKm())+
                '\n'+"Amount spent on food: "+"$"+f.getfoodCost(this.isIfFood()));
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "baseSalary=" + baseSalary +
                ", salesVolume=" + salesVolume +
                '}';
    }
}