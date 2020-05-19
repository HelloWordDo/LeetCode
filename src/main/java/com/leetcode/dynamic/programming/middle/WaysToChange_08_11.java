package com.leetcode.dynamic.programming.middle;

/**
 * 面试题 08.11. 硬币
 */
public class WaysToChange_08_11 {

    public static int waysToChange(int n) {

        int[] coins = new int[]{1, 5, 10, 25};

        int[][] dp = new int[coins.length][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i])
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - coins[i]]) % 1000000007;
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[3][n];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + waysToChange(10));
    }

}
