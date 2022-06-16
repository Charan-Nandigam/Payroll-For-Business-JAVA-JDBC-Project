package com.company;

public class TooMuchSalaryException extends Throwable {

    public TooMuchSalaryException() {


    }
    public TooMuchSalaryException(String s) {

System.out.println(s);
  }
    public void salaryCheck(double out) throws TooMuchSalaryException {
        if ( out > 1000000)
            throw new TooMuchSalaryException("The salary is beyond the nominal amount please recheck");
        else {
            System.out.println();
        }
    }
    }
