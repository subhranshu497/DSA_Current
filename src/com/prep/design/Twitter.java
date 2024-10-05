package com.prep.design;

import java.util.*;

public class Twitter {
    private class Tweet{
        int id;
        int time;
        Tweet next;
        Tweet(int id){
            this.id = id;
            this.time = time++;
            this.next = null;
        }
    }
    class User{
        int userId;
        Set<Integer> followed;
        Tweet tweetHead;
        User(int id){
            this.userId =userId;
            followed = new HashSet<>();
            follow(userId); // self follow
            this.tweetHead = null;
        }
        public void follow(int userId){
            followed.add(userId);
        }
        public void unFollow(int userId){
            followed.remove(userId);
        }
        public void post(int userId){
            Tweet t = new Tweet(userId);
            t.next = tweetHead;
            tweetHead = t;
        }
    }
    // user - tweet map
    Map<Integer, User> userTweetMap;
    int size;
    public Twitter() {
        userTweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if(!userTweetMap.containsKey(userId)){
            User u = new User(userId);
            userTweetMap.put(userId, u);
        }
        else {
            userTweetMap.get(userId).post(tweetId);
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if(!userTweetMap.containsKey(userId))   return res; // empty result

        Set<Integer> users = userTweetMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
        for(int user: users){
            Tweet t = userTweetMap.get(user).tweetHead;
            if(t!=null){
                q.add(t);
            }
        }
        int n=0;
        while(!q.isEmpty() && n<10){
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if(t.next!=null)
                q.add(t.next);
        }

        return res;


    }

    public void follow(int followerId, int followeeId) {
        if(!userTweetMap.containsKey(followerId)){
            User u = new User(followerId);
            userTweetMap.put(followerId, u);
        }
        if(!userTweetMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userTweetMap.put(followeeId, u);
        }
        userTweetMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(!userTweetMap.containsKey(followerId) || followerId==followeeId) return;
        userTweetMap.get(followerId).unFollow(followeeId);
    }
}
