package com.leetcode.dynamic.programming.middle;

/**
 * 983. 最低票价
 */
public class MincostTickets_983 {


    public static int mincostTickets(int[] days, int[] costs) {

        int length = days.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {

            int minCost;
            for (int j = i; j >= 0; j--) {

                if (i == j) {
                    dp[i][j] = costs[0];
                    continue;
                }

                int day = days[i] - days[j] + 1;
                int a = day * costs[0];
                int b = day % 7 == 0 ? (day / 7) * costs[1] : (day / 7 + 1) * costs[1];
                int c = day % 30 == 0 ? (day / 30) * costs[2] : (day / 30 + 1) * costs[2];

                minCost = Math.min(c, Math.min(a, b));

                for (int k = i; k > j; k--) {

                    int d = dp[i][k] + dp[k - 1][j];
                    minCost = Math.min(d, minCost);
                }

                dp[i][j] = minCost;
            }
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {

        System.out.println(mincostTickets(new int[]{1, 3, 7}, new int[]{1, 4, 20}));
    }
}
