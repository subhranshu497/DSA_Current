package com.prep;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int [] heights = {0,9};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] leftMin= new int[heights.length];
        int[] rightMin= new int[heights.length];
        //populate the left min array
        for(int i=0;i< leftMin.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) leftMin[i] =-1;
            else leftMin[i] = stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty()) stack.pop();
        //populate the right min array
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()) rightMin[i] = heights.length;
            else rightMin[i] = stack.peek();
            stack.push(i);
        }
        //calculate Area
        int area = 0;
        for(int i=0;i<heights.length;i++){
            area = Math.max(area, (rightMin[i]-leftMin[i]-1)*heights[i]);
        }
        return area;
    }
}
