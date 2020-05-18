package com.leetcode.dynamic.programming.middle;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class MaxProfit_714 {

    public static int maxProfit(int[] prices, int fee) {

        int[][] dp = new int[2][prices.length];

        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {

            dp[0][i] = Math.max(dp[1][i - 1] + prices[i] - fee, dp[0][i - 1]);

            dp[1][i] = Math.max(dp[0][i - 1] - prices[i], dp[1][i - 1]);

        }
        return dp[0][prices.length - 1];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }

}
