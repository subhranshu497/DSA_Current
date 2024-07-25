package com.prep;

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int [] arr = {1,2,34,3,4,5,70,23,12};
        boolean flag = threeConOdds(arr);
        System.out.println(flag);
    }

    private static boolean threeConOdds(int[] arr) {
        int i =0;
        while (i<arr.length){
            boolean flag =false;
            int j=i;
            int count =0;
            while(arr[j]%2 !=0 && count !=3){
                flag =true;
                count++;
                j++;
            }
            if(count ==3) return true;
            if(flag) i =j+1;
            else i++;
        }
        return false;
    }
}
