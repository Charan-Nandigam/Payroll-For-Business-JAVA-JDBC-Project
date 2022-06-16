package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {

    public static  void main(String[] args) throws TooMuchSalaryException, ApplyTransportException, ExcessDistanceException, SQLException, FileNotFoundException {
        //Create reference variable of all three employee types
//         FullTimeEmployee FullTimeEmp;
//        PartTimeEmployee  PartTimeEmp;
//         SalesEmployee SalesEmp;
        //Declare variables to input
        char inputEmployeeType;
        String inputFirstName;
        String inputLastName;
        double inputBaseSalary;
        double inputPayPerHour;
        int inputSalesVolume;
        int inputHoursWorked;
        int inputKm;
        boolean inputIfFood;
        boolean inputIsVeg;
        boolean inputIfTransport;
        
        
        String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password ="12345";
		
		
		Connection conn = DriverManager.getConnection(dbURL,username,password);
		System.out.println("Connected to oracle server");
			
		
	
		
		Statement stmt = conn.createStatement();
		
		System.out.println("Inserting records into the table...");          
       
        


        //Get two input values
        Scanner scannedInfo = new Scanner(System.in);

            System.out.print("Enter Employee File : ");
            System.out.flush();
        while (scannedInfo.hasNextLine()) {
            inputEmployeeType = scannedInfo.next().charAt(0);
            System.out.println();


            switch (inputEmployeeType) {
                case 'F':
                case 'f':
                    //get necessary values as input
//                System.out.print("Enter First Name, " +
//                        "Last Name, Base Salary, Hours : ");
                    //System.out.flush();
                    inputFirstName = scannedInfo.next();
                    inputLastName = scannedInfo.next();
                    inputBaseSalary = scannedInfo.nextDouble();
                    inputHoursWorked = scannedInfo.nextInt();
                    inputIfFood=scannedInfo.nextBoolean();
                    String foodString = String.valueOf(inputIfFood);
                    inputIsVeg=scannedInfo.nextBoolean();
                    String vegString= String.valueOf(inputIsVeg); 
                   inputIfTransport=scannedInfo.nextBoolean();
                   String transportString = String.valueOf(inputIfTransport);
                    inputKm=scannedInfo.nextInt();
                    //String sql = "INSERT INTO EMPLOYEES(TYPE, FIRSTNAME,LASTNAME,SALARY,HOURS,FOODSTRING,VEGSTRING,TRANSPORTSTRING,KM) VALUES ('F', inputFirstName, inputLastName, inputBaseSalary, inputHoursWorked, foodString,vegString,transportString,inputKm)";
                    //stmt.executeUpdate(sql);
                    //System.out.println();
                    //create an object and initialize data members
                    
                    String sql = "insert into employees "
                			+ " (Type,FirstName,LastName,Salary,Hours,foodString,vegString,transportString,KM,pay,foodrs,transportrs)" + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
                	
                    PreparedStatement stmtt = conn.prepareStatement(sql);
                                   
                  
                	// set param values
                	char c = 'F';
                	stmtt.setObject(1,c,java.sql.Types.CHAR);
    
                	stmtt.setString(2, inputFirstName);
                	stmtt.setString(3, inputLastName);
                	stmtt.setDouble(4, inputBaseSalary);
                	stmtt.setInt(5, inputHoursWorked);
                	stmtt.setString(6, foodString);
                	stmtt.setString(7, vegString);
                	stmtt.setString(8, transportString);
                	stmtt.setInt(9, inputKm);
                	// 3. Execute SQL query
                	//stmtt.executeUpdate();
                    FullTimeEmployee emf = new FullTimeEmployee();
                    emf.setFirstName(inputFirstName);
                    emf.setLastName(inputLastName);
                    emf.setBaseSalary(inputBaseSalary);
                    emf.setHoursWorked(inputHoursWorked);
                    emf.setIfFood(inputIfFood);
                    emf.setVeg(inputIsVeg);
                    emf.setIfTransport(inputIfTransport);
                    emf.setKm(inputKm);
                   double pay= emf.computeCompensation();
                   System.out.println(pay);
                   double foodcost=emf.f.getfoodCost(inputIsVeg);
                   System.out.println(foodcost);
                   double transportcost=emf.t.getTransportCost(inputKm);
                   System.out.println(transportcost);
                   /*String sql1 = "insert into employees "
               			+ " (pay,foodrs,transportrs)" + " values (?,?,?)";
               	PreparedStatement stmtt1 = conn.prepareStatement(sql1);
               	// set param values
       
               	*/
               	stmtt.setDouble(10, pay);
            	stmtt.setDouble(11, foodcost);
            	stmtt.setDouble(12, transportcost);
            	stmtt.executeUpdate();
            	
            	
                   
                    //invoke the printPayStub method
                    if(inputKm>0 && inputIfTransport==false)
                    {
                        throw new ApplyTransportException("Apply for transport if you want your distance to be considered");
                    }
                    System.out.print(emf.createPayStub());
                    break;
                    
                    
                case 'P':
                case 'p':
                    //get necessary values as input
//                    System.out.print("Enter First Name, Last Name, " +
//                            "Pay per hour, Hours : ");
                    System.out.flush();
                    inputFirstName = scannedInfo.next();
                    inputLastName = scannedInfo.next();
                    inputPayPerHour = scannedInfo.nextDouble();
                    inputHoursWorked = scannedInfo.nextInt();
                    inputIfFood=scannedInfo.nextBoolean();
                    String foodString2 = String.valueOf(inputIfFood);
                    inputIsVeg=scannedInfo.nextBoolean();
                    String vegString2= String.valueOf(inputIsVeg);
                    inputIfTransport=scannedInfo.nextBoolean();
                    String transportString2 = String.valueOf(inputIfTransport);
                    inputKm=scannedInfo.nextInt();

                    PartTimeEmployee emp = new PartTimeEmployee();
                    
                    //PartTimeEmployee empp = new PartTimeEmployee();
                    String sql2 = "insert into employees "
                			+ " (Type,FirstName,LastName,PayPerHour,Hours,foodString,vegString,transportString,KM,pay,foodrs,transportrs)" + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
                	PreparedStatement stmttp = conn.prepareStatement(sql2);

                	char cc = 'P';
                	stmttp.setObject(1,cc,java.sql.Types.CHAR);
                	stmttp.setString(2, inputFirstName);
                	stmttp.setString(3, inputLastName);
                	stmttp.setDouble(4, inputPayPerHour);
                	stmttp.setInt(5, inputHoursWorked);
                	stmttp.setString(6, foodString2);
                	stmttp.setString(7, vegString2);
                	stmttp.setString(8, transportString2);
                	stmttp.setInt(9, inputKm);
                	emp.setFirstName(inputFirstName);
                    emp.setLastName(inputLastName);
                    emp.setPayPerHour(inputPayPerHour);
                    emp.setHoursWorked(inputHoursWorked);
                    emp.setIfFood(inputIfFood);
                    emp.setVeg(inputIsVeg);
                    emp.setIfTransport(inputIfTransport);
                    emp.setKm(inputKm);
                	double pay2= emp.computeCompensation();
                    System.out.println(pay2);
                    double foodcost2=emp.f.getfoodCost(inputIsVeg);
                    System.out.println(foodcost2);
                    double transportcost2=emp.t.getTransportCost(inputKm);
                    System.out.println(transportcost2);
                	stmttp.setDouble(10, pay2);
                	//stmttP.setDouble(10, pay2);
                 	stmttp.setDouble(11, foodcost2);
                 	stmttp.setDouble(12, transportcost2);
                 	//stmtt3.executeUpdate();
                    System.out.println();
                    stmttp.executeUpdate();
                    //create an object and initialize data member
                    /*String sql3 = "insert into employees "
                			+ " (pay,foodrs,transportrs)" + " values (?,?,?)";
                	PreparedStatement stmtt3 = conn.prepareStatement(sql3);
                	// set param values
        
                	*/
                
                    //invoke the printPayStub method
                    
                    
                    if(inputKm>0 && inputIfTransport==false)
                    {
                        throw new ApplyTransportException("Apply for transport if you want your distance to be considered");
                    }
                    System.out.print(emp.createPayStub());
                    break;
                case 'S':
                case 's':
                    //get necessary values as input
//                    System.out.print("Enter First Name, Last Name, " +
//                            "Base Salary, Sales Volume : ");
                    System.out.flush();
                    inputFirstName = scannedInfo.next();
                    inputLastName = scannedInfo.next();
                    inputBaseSalary = scannedInfo.nextDouble();
                    inputSalesVolume = scannedInfo.nextInt();
                    inputIfFood=scannedInfo.nextBoolean();
                    String foodString3 = String.valueOf(inputIfFood);
                    inputIsVeg=scannedInfo.nextBoolean();
                    String vegString3= String.valueOf(inputIsVeg);
                    inputIfTransport=scannedInfo.nextBoolean();
                    String transportString3 = String.valueOf(inputIfTransport);
                    inputKm=scannedInfo.nextInt();
                    System.out.println();
                    //create an object and initialize data members
                    SalesEmployee ems = new SalesEmployee();
                    
                    String sql3 = "insert into employees "
                			+ " (Type,FirstName,LastName,Salary,salesvolume,foodString,vegString,transportString,KM,pay,foodrs,transportrs)" + " values (?,?,?,?,?,?,?,?,?,?,?,?)";
                	PreparedStatement stmtts = conn.prepareStatement(sql3);

                	char ccc = 'S';
                	stmtts.setObject(1,ccc,java.sql.Types.CHAR);
                	stmtts.setString(2, inputFirstName);
                	stmtts.setString(3, inputLastName);
                	stmtts.setDouble(4, inputSalesVolume);
                	stmtts.setInt(5, inputSalesVolume);
                	stmtts.setString(6, foodString3);
                	stmtts.setString(7, vegString3);
                	stmtts.setString(8, transportString3);
                	stmtts.setInt(9, inputKm);
                    
                    ems.setFirstName(inputFirstName);
                    ems.setLastName(inputLastName);
                    ems.setBaseSalary(inputBaseSalary);
                    ems.setSalesVolume(inputSalesVolume);
                    ems.setIfFood(inputIfFood);
                    ems.setVeg(inputIsVeg);
                    ems.setIfTransport(inputIfTransport);
                    ems.setKm(inputKm);
                    double pay3= ems.computeCompensation();
                    System.out.println(pay3);
                    double foodcost3=ems.f.getfoodCost(inputIsVeg);
                    System.out.println(foodcost3);
                    double transportcost3=ems.t.getTransportCost(inputKm);
                    System.out.println(transportcost3);
                	stmtts.setDouble(10, pay3);
                	//stmttP.setDouble(10, pay2);
                 	stmtts.setDouble(11, foodcost3);
                 	stmtts.setDouble(12, transportcost3);
                 	//stmtt3.executeUpdate();
                    System.out.println();
                    stmtts.executeUpdate();
                    if(inputKm>0 && inputIfTransport==false)
                    {
                        throw new ApplyTransportException("Apply for transport if you want your distance to be considered");
                    }

                    //invoke the printPayStub method
                    System.out.print(ems.createPayStub());
                    break;
            }

        }

    }
}
/*
   F Anirudh Ravichandran 10008 82 true true true 15
   F Joyce Witt 342.67 80  false false false 0
   F Mike Morse 1423.56 75 false false false 0
   S Patrick McCoy 1040.5 856 false false false 0
   P Chris Olsen 34.56 34 false false false 0
   Q

*/