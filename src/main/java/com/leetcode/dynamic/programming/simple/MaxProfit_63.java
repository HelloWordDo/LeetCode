package com.leetcode.dynamic.programming.simple;

/**
 * 面试题63. 股票的最大利润=121题
 */
public class MaxProfit_63 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        int[] m = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                m[i] = prices[i] - min;
                max = Math.max(max, m[i]);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

}
