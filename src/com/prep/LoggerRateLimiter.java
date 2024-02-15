package com.prep;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    private Map<String, Integer> messagequeue;

    public LoggerRateLimiter(){
        messagequeue = new HashMap<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messagequeue.containsKey(message)){
            messagequeue.put(message, timestamp);
            return true;
        }
        else{
            int time = messagequeue.get(message);
            if(timestamp-time <10) return false;
            messagequeue.put(message, timestamp);
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
