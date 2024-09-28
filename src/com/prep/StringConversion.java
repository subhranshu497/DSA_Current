package com.prep;

public class StringConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows =4;
        String str = convertStr(s, numRows);
        System.out.println(str);
    }

    private static String convertStr(String s, int numRows) {
        String [] ans = new String[s.length()];
        for(int i=0;i<s.length();i++)ans[i]="";
        int i=0;
        while(i<s.length()){
            for(int idx=0;idx<numRows && i<s.length();idx++){
                ans[idx] += s.charAt(i++);
            }
            for(int idx=numRows-2;idx>0 && i <s.length();idx--){
                ans[idx] +=s.charAt(i++);
            }
        }
        String resultStr ="";
        for(String str:ans)resultStr +=str;
        return resultStr;
    }
}
