package com.leetcode.dynamic.programming;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class MaxProfit_309 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        int maxProfit = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
