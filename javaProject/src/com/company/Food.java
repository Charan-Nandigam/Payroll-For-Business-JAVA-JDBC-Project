package com.company;

public class Food  {
    private static final int veg_cost = 500;
    private static final int nonveg_cost = 700;

    public Food() {

    }

    public static int getVeg_cost() {
        return veg_cost;
    }

    public static int getNonveg_cost() {
        return nonveg_cost;
    }

    public double getfoodCost(boolean isVeg) {
        double costFood=0;


            if (isVeg) {
                costFood = Food.getVeg_cost();
            } else {
                costFood = Food.getNonveg_cost();
            }


        return costFood;
    }
}
