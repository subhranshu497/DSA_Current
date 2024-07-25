package com.prep;

import java.util.HashMap;
import java.util.Map;

public class CountSubstringsWithoutRepeatingCharacter
{
    public static void main(String[] args) {
        String s = "abcd";
        int subStringCount = numberOfSpecialSubstrings(s);
        System.out.println(subStringCount);
    }

    private static int numberOfSpecialSubstrings(String s) {
       int ans = 0;
       int i =-1, j=-1;
        Map<Character, Integer> map = new HashMap<>();
       while(true){
           boolean flag1 = false;
           boolean flag2 =false;
           while(i<s.length()-1){
               flag1 =true;
               i++;
               map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
               if(map.get(s.charAt(i))==2) break;
               else ans +=i-j;
           }
           while(j<i){
               flag2=true;
               j++;
               map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)-1);
               if(map.get(s.charAt(j))==1) {
                   ans +=i-j;
                   break;
               }
           }
           if(flag1==false && flag2==false)break;
       }
       return ans;
    }
}
