package com.prep;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int [] customer = {1,0,1,2,1,1,7,5};
        int [] grumpy =   {0,1,0,1,0,1,0,1};
        int minutes = 3;
        int ans = maxSatisfied(customer, grumpy, minutes);
        System.out.println(ans);
    }

    private static int maxSatisfied(int[] customer, int[] grumpy, int minutes) {
        int sum =0;
        for(int i=0;i<customer.length;i++){
            if(grumpy[i]==0) sum +=customer[i];
        }
        int unSatisfiedCustomer=0;
        int maxUnSatisfiedCustomer=0;
        for(int i=0;i<minutes;i++){
            unSatisfiedCustomer += customer[i]*grumpy[i];
        }
        maxUnSatisfiedCustomer = unSatisfiedCustomer;
        int left =0;
        int right = minutes;

        while(right<customer.length){
            unSatisfiedCustomer += customer[right]*grumpy[right];
            unSatisfiedCustomer -= customer[left]*grumpy[left];
            maxUnSatisfiedCustomer = Math.max(maxUnSatisfiedCustomer, unSatisfiedCustomer);
            left++;
            right++;
        }
        return sum+maxUnSatisfiedCustomer;
    }
}
