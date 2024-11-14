package com.prep;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    public static void main(String[] args) {
        int [] quantities = {11,6};
        int n = 6;
        int ans = minimizedMaximum(n, quantities);
        System.out.println(ans);
    }

    private static int minimizedMaximum(int n, int[] quantities) {
            int ans = Integer.MAX_VALUE;
            int left = 1;
            int right =0;
            //find right
            for(int q:quantities){
                right = Math.max(q, right);
            }

            while (left <=right){
                int mid = left+(right-left)/2;
                if(canDistribute(n, quantities, mid)){
                    ans = Math.min(ans, mid);
                    right = mid-1;
                }
                else left = mid+1;
            }
            return ans;
        }
        private static boolean canDistribute(int n, int[] quantities, int product) {
            int assignedProduct =0;
            for(int q:quantities){
                assignedProduct += Math.ceilDiv(q,product);
            }
            return assignedProduct <=n;
        }
}
