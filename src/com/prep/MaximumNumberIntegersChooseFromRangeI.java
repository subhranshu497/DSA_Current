package com.prep;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberIntegersChooseFromRangeI {
    public static void main(String[] args) {
        int [] banned = {11};
        int n =7;
        int maxsum = 50;
        int res = maxCount(banned, n, maxsum);
        System.out.println(res);
    }

    private static int maxCount(int[] banned, int n, int maxsum) {
        int count =0;
        int tempSum = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:banned)
            set.add(num);
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                tempSum +=i;
                if(tempSum <=maxsum)
                    count++;
            }
        }
        return count;
    }
}
