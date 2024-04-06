package com.prep;

import java.util.Stack;

public class AstroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-1,-2,1,3,1,2,-3,3};
        int [] result = collisionCheck(asteroids);
    }

    private static int[] collisionCheck(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int val:asteroids){
            if(val>0) stack.push(val);
            else{
               while(stack.size()>0 && stack.peek()>0 && stack.peek() < -val) stack.pop();
               if(stack.size() >0 && stack.peek()==-val) stack.pop();
               else if (stack.size() >0 && stack.peek()>-val){

               }
               else stack.push(val);
            }
        }
        int [] ans = new int[stack.size()];
        for(int i = ans.length-1;i>=0;i--){
            ans[i]=stack.pop();
        }
        return ans;
    }
}
