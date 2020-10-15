package com.leetcode.greedy.simple;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class MaxProfit_122 {

    public static int maxProfit(int[] prices) {

        int len = prices.length;

        int profit = 0;
        for (int i = 1; i < len; i++) {

            if (prices[i] - prices[i - 1] > 0) {

                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
