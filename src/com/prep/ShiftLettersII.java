package com.prep;

public class ShiftLettersII {
    public static void main(String[] args) {
        int [][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        String s = "abc";
        String res = shiftingLettersII(s, shifts);
        System.out.println(res);
    }

    private static String shiftingLettersII(String s, int[][] shifts) {
        int n = s.length();
        int [] arr = new int[n];

        for(int[] shift :shifts){
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if(direction==1){
                arr[start] +=1;
                if(end+1 < n)
                    arr[end+1] -=1;
            }
            else{
                arr[start] -=1;
                if(end+1 < n)
                    arr[end+1] +=1;
            }

        }
        //prefix sum
        for(int i=1;i<n;i++){
            arr[i] +=arr[i-1];
        }
        //form the result string
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<n;i++){
            int step = arr[i] % 26;
            if(step <0)
                step +=26;
            char ch = (char) (((s.charAt(i)-'a' + step)% 26)+ 'a');
            sb.setCharAt(i, ch);
        }
        return sb.toString();
    }
}
