package com.prep;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI {
    public static void main(String[] args) {
        String s = "aaaa";
        int res = maximumLength(s);
        System.out.println(res);
    }

    private static int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for(int st=0;st<s.length();st++){
            StringBuilder sb = new StringBuilder();
            for(int end=st;end<s.length();end++){
                if(sb.length()==0 || sb.charAt(sb.length()-1 )== s.charAt(end)){
                    sb.append(s.charAt(end));
                    map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
                } else break;
            }
        }
        int res = 0;
        for(String str:map.keySet()){
            if(map.get(str) >=3 && str.length() > res)
            {
                res = str.length();
            }
        }

        return res==0?-1:res;
    }
}
