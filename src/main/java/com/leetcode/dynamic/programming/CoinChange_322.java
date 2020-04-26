package com.leetcode.dynamic.programming;

/**
 * 322. 零钱兑换
 */
public class CoinChange_322 {

    public static int coinChange(int[] coins, int amount) {

        if (coins.length == 0) return -1;

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {

                int money = coins[j];

                if (i >= money) {
                    if (dp[i - money] != Integer.MAX_VALUE)
                        minNum = Math.min(minNum, dp[i - money] + 1);
                }
                dp[i] = minNum;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + coinChange(new int[]{2, 11, 4}, 15));
    }
}
