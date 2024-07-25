package com.prep;

import java.util.*;

public class SortTheJumbledNumbers {
    public static void main(String[] args) {
        int [] mapping = {8,9,4,0,2,1,3,5,7,6};
        int [] nums = {991, 338, 38};
        int [] result = sortJumbled(mapping, nums);
    }

    private static int[] sortJumbled(int[] mapping, int[] nums) {
        int [] result = new int[nums.length];
        Map<String, Integer> map = new LinkedHashMap<>();
        int idx=0;
        for(int num:nums){
            String s = num+"";
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                sb.append(mapping[ch-'0']);
            }
            map.put(sb.toString(), num);
            int res = Integer.parseInt(sb.toString());
            result[idx]=res;
            idx++;
        }
        System.out.println("map  "+map);
        String [] strArr = map.keySet().toArray(new String[0]);
        Map<String, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<strArr.length;i++){
            list.add(Integer.parseInt(strArr[i]));
            map2.put(strArr[i], Integer.parseInt(strArr[i]));
        }
        Collections.sort(list, (a,b)->{
            if(map2.get(a)==map2.get(b)) return a-b;
            else return map2.get(b)-map2.get(a);
        });
        System.out.println("Map2  "+map2);
        System.out.println("List post sort "+list);
        return result;
    }
}
