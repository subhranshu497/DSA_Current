package com.prep;

import java.util.*;

public class FirstUnique {
    Queue<Integer> q;
    Map<Integer, Integer> map;
    public FirstUnique(int[] nums) {
        q = new LinkedList<>();
        map = new HashMap<>();
        //put the first element in the queue and the map
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
            q.add(num);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && map.get(q.peek())>1) q.poll();
        if(q.isEmpty()) return -1;
        return q.peek();
    }

    public void add(int value) {
        q.add(value);
        if(map.containsKey(value)){
            int val = map.get(value);
            map.put(value, val+1);
        }
        else {
            map.put(value, 1);
        }
    }
}
