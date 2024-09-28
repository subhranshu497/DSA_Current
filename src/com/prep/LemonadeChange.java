package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChangeCalculate(bills));
    }

    private static boolean lemonadeChangeCalculate(int[] bills) {
        if(bills[0]>5) return false;
        int five =0, ten=0;
        for(int bill:bills){
            if(bill==5) five++;
            else if(bill==10){
                five--;
                ten++;
            }
            else if(ten >1){
                ten--;
                five--;
            }
            else five -=3;
        }
        return true;
    }
}
