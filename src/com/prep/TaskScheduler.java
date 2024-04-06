package com.prep;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char [] tasks = {'A','A','B','A','B','B'};
        int n =3;
        System.out.println(leastInterval(tasks,n));
    }

    private static int leastInterval(char[] tasks, int n) {
        int exeTime =0;
        Map<Character, Integer> hm = new HashMap<>();
        for(char ch:tasks)hm.put(ch, hm.getOrDefault(ch,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(hm.size(),Collections.reverseOrder());
        pq.addAll(hm.values());
        while(!pq.isEmpty()){
            int cycle =n+1;
            int taskCount =0;
            List<Integer> tempStore = new ArrayList<>();
            while(cycle-->0 && !pq.isEmpty()){
                int currentfreq = pq.remove();
                if(currentfreq>1) tempStore.add(currentfreq-1);
                taskCount++;
            }
            tempStore.forEach(pq::offer);
            exeTime +=(pq.isEmpty()?taskCount:n+1);
        }
        return exeTime;
    }
}
