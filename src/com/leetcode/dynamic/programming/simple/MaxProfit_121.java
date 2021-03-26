package com.leetcode.dynamic.programming.simple;

/**
 * 121. 买卖股票的最佳时机
 * <p>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    /**
     * 套用模板
     * <p>
     * 2021.3.26
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }

        int curMin = prices[0];
        for (int i = 1; i < prices.length; i++) {

            curMin = Math.min(curMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMin);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }
}
