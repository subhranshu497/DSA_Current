package com.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListBasedOnLastDigit {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(43);
        list.add(31);
        list.add(72);
        list.add(29);
        List<Integer> result = sortByLastDigit(list);
    }

    private static List<Integer> sortByLastDigit(List<Integer> list) {

//        Comparator<Integer> com = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer a, Integer b) {
//                if(a%10 > b%10)return 1;
//                else return -1;
//            }
//        };
        //Collections.sort(list, com);
        Collections.sort(list, (a,b)->{
            if(a%10 > b%10) return 1;
            else return -1;
        });
        System.out.println(list);
        return list;
    }
}
