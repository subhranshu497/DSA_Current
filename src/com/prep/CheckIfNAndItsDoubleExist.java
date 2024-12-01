package com.prep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        int [] arr = {10,2,5,3};
        boolean flag = checkIfExist(arr);
        System.out.println(flag);
    }

    private static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        for(int i=0;i<arr.length;i++){
            int dbl = 2*arr[i];
            if(map.containsKey(dbl)){
                int val = map.get(dbl);
                if(val !=i)
                    return true;
            }
        }
        return false;
    }
}
