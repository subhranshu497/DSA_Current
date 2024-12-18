package com.prep;

public class FinalPricesWithSpecialDiscountInAShop {
    public static void main(String[] args) {
        int [] prices = {10,1,1,6};
        int [] finalPrice = finalPrices(prices);

        for(int price:finalPrice)
            System.out.print(price+", ");
    }

    private static int[] finalPrices(int[] prices) {
        int [] ans = new int[prices.length];
        for(int i = 0;i< prices.length-1;i++){
            int curr = prices[i];
            boolean flag = false;
            for(int j=i+1;j< prices.length;j++){
                if(curr >= prices[j]){
                    ans[i] = curr - prices[j];
                    flag = true;
                    break;
                }
            }
            if(flag==false)
                ans[i] = prices[i];
        }
        ans[prices.length-1] = prices[prices.length-1];
        return ans;
    }
}
