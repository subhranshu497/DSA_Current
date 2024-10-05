package com.prep;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    public static void main(String[] args) {
        int [] skill = {1,1,2,3};
        long result = dividePlayers(skill);
        System.out.println(result);
    }

    private static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        if(n==2) return skill[0]*skill[1];
        //start filling the team array which will be size of 2
        //first team
        long sum = skill[0]+skill[n-1];
        long prod = skill[0]*skill[n-1];
        for(int i=1;i<n/2;i++){
            if(sum != (skill[i]+skill[n-1-i])) return -1;
            else {
                prod =prod + (skill[i]*skill[n-1-i]);
            }
        }
        return prod;
    }
}
