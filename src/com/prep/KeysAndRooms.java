package com.prep;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        keys.add(1);
        keys.add(3);
        rooms.add(keys);
        System.out.println(canVisitAllRooms(rooms));
    }

    private static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i=0;i<rooms.size();i++){
            List<Integer> list = rooms.get(i);
            adjList.put(i, list);
        }
        System.out.println(adjList);
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        stack.push(0);
        visited.add(0);
        while(!stack.isEmpty()){
            List<Integer> keys = adjList.get(stack.peek());
            int keyItem = stack.pop();
            visited.add(keyItem);
            for(int key:keys){
                if(!visited.contains(key)){
                    stack.push(key);
                }
            }
        }
        if(adjList.size()==visited.size())return true;
        return false;
    }
}
