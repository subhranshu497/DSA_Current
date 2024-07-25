package com.prep;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/","d2/","../","d21/","./"};
        int ops = minOperations(logs);
        System.out.println(ops);
    }

    private static int minOperations(String[] logs) {
        int count=0;
        for(String log:logs){
            if(count !=0){
                if(log.equals("../"))count--;
                if(log.equals("./")) continue;
            }
            else count++;
        }
        return count;
    }
}
