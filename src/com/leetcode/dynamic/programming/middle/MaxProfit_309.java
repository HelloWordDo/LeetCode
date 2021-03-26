package com.leetcode.dynamic.programming.middle;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * <p>
 * <p>
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfit_309 {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int[][] dp = new int[prices.length][3];
        //0.买股票 利润 -prices[0]
        dp[0][0] = -prices[0];
        //1.冷冻期 利润
        dp[0][1] = 0;
        //2.卖股票 利润
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][1]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }

        int maxProfit = Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
        return maxProfit;
    }


    /**
     * 套用模板 2021.3.26
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        int maxProfit = 0;
        if (prices.length == 0) {
            return maxProfit;
        }
        return dp(0, prices);
    }


    /**
     * 套用模板
     *
     * @param start
     * @param prices
     * @return
     */
    public static int dp(int start, int[] prices) {

        if (start >= prices.length) {
            return 0;
        }

        int res = 0;

        int curMin = prices[start];

        for (int i = start + 1; i < prices.length; i++) {

            curMin = Math.min(curMin, prices[i]);

            res = Math.max(res, dp(i + 2, prices) + prices[i] - curMin);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + maxProfit2(new int[]{1, 2, 3, 0, 2}));
    }
}
