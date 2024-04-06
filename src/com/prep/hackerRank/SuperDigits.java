package com.prep.hackerRank;

public class SuperDigits {
    public static void main(String[] args) {
        String n = "9875";
        int k = 4;
        System.out.println(findSuperDigit(n,k));
    }

    private static long findSuperDigit(String n, int k) {
        int num = 0;
        for(char c:n.toCharArray()){
            num +=c-48;
        }
        num *=k;
        return superRecursive(num);
    }
    private static long superRecursive(long num){
        //base condition
        if(num <= 9 && num >=0) return num;
        long sum =0;

        while(num !=0){
            sum +=num%10;
            num /=10;
        }
        return superRecursive(sum);
    }
}
