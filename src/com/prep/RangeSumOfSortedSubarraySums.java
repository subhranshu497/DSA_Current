package com.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int left = 1;
        int right = 5;
        int n = 4;
        int sum = rangeSum(nums,n, left, right);
    }

    private static int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subarrSum = new ArrayList<>();
        int [] cumSum = new int[n];
        cumSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
           cumSum[i] =cumSum[i-1]+ nums[i];
           subarrSum.add(cumSum[i]);
        }
        for(int num:cumSum) System.out.print(num+", ");
        subarrSum.add(cumSum[0]);
        for(int i=1;i<nums.length;i++){
            for(int j=i;j< nums.length;j++){
                subarrSum.add(cumSum[j]-cumSum[i-1]);
            }
        }
        System.out.println();
        for(int num:subarrSum) System.out.print(num+", ");
        Collections.sort(subarrSum);
        int mod = 1000000007;
        int sum =0;
        for(int i=left-1;i<right;i++){
            sum +=subarrSum.get(i);
        }
        System.out.println(sum);
        return sum%mod;
    }

    private static int rangeSumII(int[] nums, int n, int left, int right) {
        int mod = 1000000007;
        List<List<Integer>> allSubArr = new ArrayList<>();
        findAllSubarrays(nums,0,0, allSubArr);
        for(List<Integer> list :allSubArr) System.out.print(list+", ");
        System.out.println();
        List<Integer> sumArr = findSumofSubArr(allSubArr);
        Collections.sort(sumArr);
        for(int i=0;i<sumArr.size();i++) System.out.print(sumArr.get(i)+", ");
        System.out.println();
        int sum =0;
        for(int i=left-1;i<right;i++){
            sum +=sumArr.get(i);
        }
        System.out.println(sum);
        return sum;
    }

    private static List<Integer> findSumofSubArr(List<List<Integer>> allSubArr) {
        List<Integer> sumArr = new ArrayList<>();
        for(List<Integer> list:allSubArr){
            int sum =0;
            for(int i=0;i<list.size();i++){
                sum +=list.get(i);
            }
            sumArr.add(sum);
        }
        return sumArr;
    }

    public static void findAllSubarrays(int[] array, int start, int end, List<List<Integer>> result) {
        // Base case: If end index reaches the length of the array
        if (end == array.length) {
            return;
        }
        // If start index is greater than end index, reset start and move to the next end index
        else if (start > end) {
            findAllSubarrays(array, 0, end + 1, result);
        }
        // Generate subarray from start to end and add to the result
        else {
            List<Integer> subarray = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                subarray.add(array[i]);
            }
            result.add(subarray);
            // Move to the next starting index
            findAllSubarrays(array, start + 1, end, result);
        }
    }
}
