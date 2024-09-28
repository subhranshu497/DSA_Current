package com.prep;

public class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        int count = countSeniors(details);
        System.out.println(count);
    }

    private static int countSeniors(String[] details) {
        int count =0;
        for(String citizen:details){
            if(Integer.parseInt(citizen.substring(11,13)) > 60)count++;
        }
        return count;
    }
}
