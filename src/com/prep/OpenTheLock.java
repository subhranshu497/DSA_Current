package com.prep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public static void main(String[] args) {
        String[] deadEnds= {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadEnds, target));
    }

    private static int openLock(String[] deadEnds, String target) {
        Set<String> visited = new HashSet<>();
        for(String deadEnd:deadEnds)visited.add(deadEnd);
        Queue<String> q = new LinkedList<>();
        int level =0;
        q.offer("0000");
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String current = q.poll();
                if(visited.contains(current)) continue;
                if(current.equals(target)) return level;
                for(String nextLock:getStateLockList(current)){
                    if(!visited.contains(nextLock)) q.offer(nextLock);
                }
                visited.add(current);
            }
            level++;
        }
        return -1;
    }

    private static Set<String> getStateLockList(String lock) {
        Set<String> newLock = new HashSet<>();
        char[] lockChar = lock.toCharArray();
        for(int i=0;i<4;i++){
            char c = lockChar[i];
            lockChar[i] = c=='9'?'0':(char)(c+1);
            newLock.add(new String(lockChar));
            lockChar[i] = c=='0'?'9':(char)(c-1);
            newLock.add(new String(lockChar));
            lockChar[i] = c;
        }
        return newLock;
    }
}
