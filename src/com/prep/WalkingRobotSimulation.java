package com.prep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WalkingRobotSimulation {
    public static void main(String[] args) {
        int [] commands = {4,-1,3};
        int [][] obstacles = {{2,4}};
        int distance = roboSim(commands, obstacles);
        System.out.println(distance);
    }

    private static int roboSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>();
        for(int [] obs:obstacles){
            String key = obs[0]+"-"+obs[1];
            set.add(key);
        }
        int x =0;
        int y=0;
        int maxD=0;
        //pointing to north
        int [] dir ={0,1};
        //processing each commands
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){//left
                dir = new int[]{-dir[1], dir[0]};
            }
            else if(commands[i]==-1){//right
                dir = new int[]{dir[1], -dir[0]};
            }
            else { //move forward step by step
                for(int step=0;step<commands[i];step++){
                    int newx = x +dir[0];
                    int newy = y+ dir[1];
                    String newKey = newx+"-"+newy;
                    if(set.contains(newKey)) break;
                    //move to new position
                    x = newx;
                    y = newy;
                }
            }
            maxD = Math.max(maxD, (x*x)+(y*y));
        }
        return maxD;
    }
}



