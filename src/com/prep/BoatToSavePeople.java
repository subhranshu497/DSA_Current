package com.prep;

import java.util.Arrays;

public class BoatToSavePeople {
    public static void main(String[] args) {
        int [] people = {3,5,4,3};
        int limit = 5;
        System.out.println(numRescueBoat(people, limit));
    }

    private static int numRescueBoat(int[] people, int limit) {
        Arrays.sort(people);
        int left =0;
        int right = people.length-1;
        int boats =0;
        while (left <= right){
            if(people[left]+people[right]<=limit) left++;
            boats++;
            right--;
        }
        return boats;
    }
}
