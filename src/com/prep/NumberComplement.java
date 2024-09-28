package com.prep;

public class NumberComplement {
    public static void main(String[] args) {
        int num = 5;
        int com = numCom(num);
        System.out.println(com);
    }

    private static int numCom(int num) {
        int com = 0;
        String s ="";
        while(num !=0){
            int rem = num %2;
            num /=2;
            s +=rem;
        }
        String s1="";
        for(int i=s.length()-1;i>=0;i--){
            s1 +=s.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        //find complement
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==0)sb.append(1);
            if(s1.charAt(i)==1)sb.append(0);
        }
        String s2=sb.toString();
        System.out.println(s2);
        //convert to decimal again
        for(int i=0;i<s2.length();i++){
            int digit = Character.getNumericValue(s2.charAt(i));
            com +=digit*Math.pow(2, s2.length()-1-i);
        }
        return com;
    }
}
