package com.prep.hackerRank;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,2,3,4,5);


        int k = 2;
        List<Integer> result = rotateLeftHR(nums, k);
        System.out.println(result);
    }

    private static List<Integer> rotateLeftHR(List<Integer> nums, int k) {
        Integer[] intArr = nums.toArray(Integer[]::new);
        int n = intArr.length;
        List<Integer>res = new ArrayList<>();
        for(int i =0;i< n;i++){
            res.add(intArr[(k+i)%n]);
        }
        return res;
    }
}
