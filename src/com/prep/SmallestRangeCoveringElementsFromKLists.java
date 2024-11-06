package com.prep;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringElementsFromKLists {
    public static void main(String[] args) {
        //int []{{4,10,15,24,26},{0,9,12,20},{5,18,22,30}};
        List<List<Integer>> nums = new ArrayList<>();
        int [] result = smallestRange(nums);
    }

    private static int[] smallestRange(List<List<Integer>> nums) {
        int len = nums.size();
        // keep track of min element from each list
        //select the min from the list and keep on increasing it until any of the  pointer got out of bound
        //pq is of list type - min value, indexFromCurrentList, indexofOuterList
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int maxEmlement = Integer.MIN_VALUE;
        //initialize the pq with aal the min element
        for(int i=0;i< len;i++){
            pq.add(new int[]{nums.get(i).get(0),i,0});
            maxEmlement = Math.max(maxEmlement, nums.get(i).get(0));
        }
        //initialize result range
        int [] resultRange = {-100000, 100000};

        while(!pq.isEmpty()){
            int [] curr= pq.poll();
            int minElement = curr[0];
            int listIndex = curr[1];
            int index = curr[2];
            if((maxEmlement-minElement) < (resultRange[1]-resultRange[0])){
                resultRange[0]= minElement;
                resultRange[1]= maxEmlement;
            }
            if(index+1 < nums.get(listIndex).size()){
                int next = nums.get(listIndex).get(index+1);
                pq.add(new int[]{next,listIndex,index+1});
                maxEmlement = Math.max(maxEmlement, next);
            }
            else break;
        }
        return resultRange;
    }
}
