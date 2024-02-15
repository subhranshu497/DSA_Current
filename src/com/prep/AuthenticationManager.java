package com.prep;

import java.util.*;

public class AuthenticationManager {
    private Map<String, Integer> tokenMap;
    private int timeToLive;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
        tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        if(!tokenMap.containsKey(tokenId)){
            tokenMap.put(tokenId, currentTime+timeToLive);
        }
    }

    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId)){
            int attachedTime = tokenMap.get(tokenId);
            if(attachedTime>currentTime){
                tokenMap.put(tokenId,currentTime+timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        Collection<Integer> allTokensTime = tokenMap.values();
        int count =0;
        for(int tokenTime:allTokensTime){
            if(tokenTime>currentTime){
                count++;
            }
        }
        return count;
    }
}
