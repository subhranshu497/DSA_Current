package com.prep;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        String s = "cdbcbbaaabab";
        int x =4;
        int y =5;
        int score = maxScoreRemovingSubString(s, x,y);
        System.out.println(score);
    }

    //x =ab , y =ba
    private static int maxScoreRemovingSubString(String s, int x, int y) {
        int score =0;
        int n=s.length();
        if(n==1)return 0;
        boolean flag =false;
        if(y>x)flag =true;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i=0;i<n;i++){
            if(!stack1.isEmpty()){
                if(flag){
                    if(s.charAt(i)=='a'){
                        char ch =stack1.peek();
                        if(ch =='b'){
                            stack1.pop();
                            score +=y;
                        }
                    }
                    else stack1.push(s.charAt(i));
                }
                else{
                    if(s.charAt(i)=='b'){
                        char ch =stack1.peek();
                        if(ch =='a'){
                            stack1.pop();
                            score +=x;
                        }
                    }
                    else stack1.push(s.charAt(i));
                }

            }
            else stack1.push(s.charAt(i));
        }
        for(int i=0;i<n;i++){
            if(!stack2.isEmpty()){
                if(!flag){
                    if(s.charAt(i)=='b'){
                        char ch =stack2.peek();
                        if(ch =='a'){
                            stack2.pop();
                            score +=x;
                        }
                    }
                    else stack2.push(s.charAt(i));
                }
                else{
                    if(s.charAt(i)=='a'){
                        char ch =stack2.peek();
                        if(ch =='b'){
                            stack2.pop();
                            score +=y;
                        }
                    }
                    else stack2.push(s.charAt(i));
                }

            }
            else stack2.push(s.charAt(i));
        }
        return score;
    }
}
