package com.leetcode.dynamic.programming.middle;

/**
 * 650. 只有两个键的键盘
 */
public class MinSteps_650 {

    public static int minSteps(int n) {

        int[] dp = new int[n + 1];
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 3;
        }
        dp[1] = 0;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {

            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 2;
            } else {

                for (int j = 2; j <= i / 2; j++) {

                    if (i % j == 0) {

                        dp[i] = dp[i / j] + j;
                        break;
                    }

                    if (j == i / 2) {
                        dp[i] = i;
                    }
                }
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {

        System.out.println(minSteps(741));
    }
}

