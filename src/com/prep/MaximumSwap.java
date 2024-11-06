package com.prep;

public class MaximumSwap {
    public static void main(String[] args) {
        int num = 2736;
        int res = maximumSwap(num);
        System.out.println(res);
    }

    private static int maximumSwap(int num) {
        String str = String.valueOf(num);

        int len = str.length();
        //to find the index of maxright element
        int [] maxRight = new int[len];
        maxRight[len-1]=len-1;
        for(int i=len-2;i>=0;i--){
            int rightMaxIndex = maxRight[i+1];
            int rightMaxEle = str.charAt(rightMaxIndex);
            maxRight[i] = str.charAt(i) >rightMaxEle ? i:rightMaxIndex;
        }
        for(int i=0;i<len;i++){
            int maxRightIndex = maxRight[i];
            int maxRightEle = str.charAt(maxRightIndex);
            if(str.charAt(i) < maxRightEle){
                String s = swap1(i,maxRightIndex, str);
                return Integer.parseInt(s);
            }
        }
        return num;
    }

    private static String swap1(int i1, int i2, String str) {
        char[] charArr = str.toCharArray();
        char temp = charArr[i1];
        charArr[i1]=charArr[i2];
        charArr[i2] = temp;
        return new String(charArr);
    }

}
