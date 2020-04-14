package com.leetcode.dynamic.programming;

/**
 * 121. 买卖股票的最佳时机
 */
public class MaxProfit_121 {

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }
        int[] m = new int[prices.length];

        m[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {

            m[i] = Math.min(m[i - 1], prices[i]);
            int c = prices[i];
            if (c - m[i] > maxProfit) {
                maxProfit = c - m[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
