package com.prep;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {
        int[] persons = {5,1,1,1};
        int k =0;
        System.out.println(timeRequiredToBuyUsingQ(persons,k));
    }

    private static int timeRequiredToBuy(int[] persons, int k) {
        int n = persons.length;
        int count =0;
        int result =0;
        while(persons[k] !=0){
            count =0;
            for(int j=0;j<n;j++){
                if(persons[j] !=0){
                        persons[j]--;
                        count++;
                }

            }
            result +=count;
        }
        return result;
    }
    //using queue
    private static int timeRequiredToBuyUsingQ(int[] tickets, int k) {
        int time =0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.offer(i);
        }
        //process the queue
        while(!q.isEmpty()){
            int front =q.poll();
            time++;
            tickets[front]--;
            if(front ==k && tickets[front]==0) return time;
            if(tickets[front] != 0){
                q.offer(front);
            }
        }
        return time;
    }

}
