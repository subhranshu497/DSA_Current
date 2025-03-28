package com.prep;

import java.util.Arrays;
import java.util.Comparator;

public class FillingBookcaseShelves {
    public static void main(String[] args) {
        int [][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        int minHeight = minHeightShelves(books, shelfWidth);
        System.out.println(minHeight);
    }
    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // Base case: no books require 0 height

        for (int i = 1; i <= n; ++i) {
            int total_width = 0;
            int max_height = 0;
            for (int j = i; j > 0; --j) {
                total_width += books[j-1][0];
                if (total_width > shelfWidth) {
                    break;
                }
                max_height = Math.max(max_height, books[j-1][1]);
                dp[i] = Math.min(dp[i], dp[j-1] + max_height);
            }
        }

        return dp[n];
    }
}
