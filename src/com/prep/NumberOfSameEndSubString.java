package com.prep;

public class NumberOfSameEndSubString {
    public static void main(String[] args) {
        String s = "abcaab";
        int [][] queries = {{0,0},{1,4},{2,5},{0,5}};
        int[] num =  sameEndSubstringCount(s, queries);
    }

    private static int[] sameEndSubstringCount(String s, int[][] queries) {
        int qLen = queries.length;
        int [] ans = new int[qLen];
        int n = s.length();
        int [][] freq = new int [n][26];
        for(int i=0;i<n;i++){
            if(i>0){
                for(int j=0;j<26;j++){
                    freq[i][j] = freq[i-1][j];
                }
            }
            char ch = s.charAt(i);
            freq[i][ch-'a'] +=1;
        }
        int index =0;
        for(int [] q:queries){
            int st = q[0];
            int end = q[1];

            int curAns =0;
            for(int j =0;j<26;j++){
                int charCount = freq[end][j] - (st > 0 ? freq[st - 1][j] : 0);
                curAns += charCount * (charCount + 1) / 2;
            }
            ans[index] = curAns;
            index += 1;
        }
        return ans;
    }
}
