package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistanceTraveled {
    public static void main(String[] args) {
        List<Integer> robot = new ArrayList<>(List.of(0, 4, 6));
        int [][] factory = {{2,2},{6,2}};
        long dist = minimumTotalDistance(robot, factory);
        System.out.println(dist);
    }

    private static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a,b)->a[0]-b[0]);
        //expand factory. write the x co the no of times factory limit is mentioned
        List<Integer> position = new ArrayList<>();
        for(int [] fact:factory){
            for(int i=0;i<fact[1];i++){
                position.add(fact[0]);
            }
        }
        int n = robot.size();
        int m = position.size();
        Collections.sort(position);
        System.out.println(position);
        return solveRobot(0,0,n,m, robot,position);
    }

    private static long solveRobot(int r, int pos, int n, int m, List<Integer> robot, List<Integer> position) {
        //base
        if(r >= n) return 0;
        if(pos >=m) return Long.MAX_VALUE;
        // take factory
        long take = Math.abs(robot.get(r)-position.get(pos))+solveRobot(r+1, pos+1,n,m,robot, position);
        // skip factory
        long skip = solveRobot(r, pos+1,n,m,robot, position);
        return Math.min(take, skip);
    }
}
