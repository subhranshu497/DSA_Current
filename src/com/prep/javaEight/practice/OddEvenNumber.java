package com.prep.javaEight.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OddEvenNumber {

    public static void main(String[] args) {
        List<Integer> list =List.of(1,2,3,4,5,6,7,8,9);

          determineOddEven(list);
    }

    private static void determineOddEven(List<Integer> list) {
       List<Integer> op= list.stream().filter(x->x%2 !=0).collect(Collectors.toList());
        System.out.println(op);
    }
}
