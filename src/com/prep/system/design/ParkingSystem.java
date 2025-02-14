package com.prep.system.design;

public class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        //before adding car, check if there is space .
        // in case of no space , return false
        if((carType==1 && big == 0)||(carType==2 && medium == 0) ||(carType==3 && small == 0)) return false;
        else if(carType==1) big--;
        else if(carType==2) medium--;
        else if(carType==3) small--;
        return true;
    }
}
