package com.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Leetcode 2092
public class FindAllPeopleWithSecret {
    public static void main(String[] args) {
        int n =6;
        int[][] meetings = {{1,2,5},{2,3,8},{1,5,10}};
        int firstPerson = 1;
        //List<Integer> result = findAllPeople(n, meetings, firstPerson);
        //System.out.println(result);
    }

//    private static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        //create an adjuncency list based on the time
//        Map<Integer, List<int[]>> graph = new HashMap<>();
//        for(int[] meeting:meetings){
//            int x = meeting[0];
//            int y = meeting[1];
//            int time = meeting[2];
//            if(graph.containsKey(time)){
//                graph.get(time).add(new int[]{x,y});
//            }
//            graph.put(time, new ArrayList<>().add(new int[]{x,y});
//        }
//        return new ArrayList<>();
//    }
}
