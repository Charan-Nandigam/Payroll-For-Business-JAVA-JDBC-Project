package com.company;

public class Transport {

    private static final int costperKm=5;




    public Transport()
    {
        super();
    }







    public static int getCostperKm() {
        return costperKm;
    }

    public double getTransportCost(int km) throws ExcessDistanceException {

        if(km>25)
        {
            throw new ExcessDistanceException("Company transport is available only within the range of25km");
        }
        return km* Transport.getCostperKm();
    }





}