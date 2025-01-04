package com.prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ContinuousSubarrays {
    public static void main(String[] args) {
        int [] nums = {5,4,2,4};
        long res = continuousSubarrays(nums);
        System.out.println(res);
    }
        public static long continuousSubarrays(int[] nums) {
            long cnt = 0;
            int l = 0, r = 0;

            PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            while (r < nums.length) {
                maxHeap.offer(new int[] { nums[r], r });
                minHeap.offer(new int[] { nums[r], r });

                while (!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek()[0] - minHeap.peek()[0]) > 2) {
                    l++;
                    while (!maxHeap.isEmpty() && maxHeap.peek()[1] < l) maxHeap.poll();
                    while (!minHeap.isEmpty() && minHeap.peek()[1] < l) minHeap.poll();
                }

                cnt += (r - l + 1);
                r++;
            }
            return cnt;
        }
}
