package com.prep;

public class MaximumNumberOfAchievableTransferRequests {
    private static int result = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int [][] requests = {{0,1},{1,0},{0,1},{1,2},{2,0},{3,4}};
        int n = 5;
        int transfer = maximumRequests(requests, n);
        System.out.println(transfer);
    }

    private static int maximumRequests(int[][] requests, int n) {
        int m = requests.length;
        int [] resultant = new int[n];
        solveTransfer(0,0,requests, resultant,m,n);
        return result;
    }

    private static void solveTransfer(int idx, int count, int[][] requests, int[] resultant, int m, int n) {
        //base case
        if(idx >=m){
            boolean allZeros = true;
            for(int num:resultant){
                if(num !=0){
                    allZeros = false;
                    break;
                }
            }
            if(allZeros){
                result = Math.max(result, count);
            }
            return;
        }
        int from = requests[idx][0];
        int to = requests[idx][1];
        //take
        resultant[from]--;
        resultant[to]++;
        solveTransfer(idx+1, count+1,requests,resultant,m,n);
        //skip
        resultant[from]++;
        resultant[to]--;
        solveTransfer(idx+1, count,requests,resultant,m,n);
    }
}
