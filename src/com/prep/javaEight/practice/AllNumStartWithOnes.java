package com.prep.javaEight.practice;

import java.util.List;
import java.util.stream.Collectors;

public class AllNumStartWithOnes {
    public static void main(String[] args) {
        List<Integer> list = List.of(10,11,12,13,14,15,16,17,20,21);
       List<String> result = filterAllNumsStartsWithOne(list);
        System.out.println(result);
    }

    private static List<String> filterAllNumsStartsWithOne(List<Integer> list) {
       return list.stream().map(s->s+"").filter(s->s.charAt(0)=='1').collect(Collectors.toList());
    }
}
