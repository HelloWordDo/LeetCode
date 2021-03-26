package com.leetcode.base;

/**
 * 股票最大利润模板
 * 只作为模板，leetcode上执行会超出时间限制
 * 但是模板没问题
 */
public class MaxProfit {

    public static int[] mem;

    public static int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        //备忘录模式，用来保存已算出来的结果
        mem = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            mem[i] = -1;
        }

        return dp(0, prices);
    }


    private static int dp(int start, int[] prices) {

        if (start >= prices.length) {
            return 0;
        }
        if (mem[start] != -1) {
            return mem[start];
        }

        int res = 0;

        int curMin = prices[start];
        for (int i = start + 1; i < prices.length; i++) {

            curMin = Math.min(curMin, prices[i]);

            /**
             * 不管怎么变化题型，主要的修改地方
             * 1.例如卖后冻结 n 天
             * dp(i + 1 + n, prices) + prices[i] - curMin
             *
             * 2.例如最多交易 k 次
             * dp(i + 1, prices, k -1) + prices[i] - curMin
             *
             * 3.例如每次卖出需要交 手续费
             * dp(i + 1, prices) + prices[i] - curMin - fee
             */
            res = Math.max(res, dp(i + 1, prices) + prices[i] - curMin);

        }
        mem[start] = res;
        return res;
    }
}
