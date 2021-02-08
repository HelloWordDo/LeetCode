package com.leetcode.dynamic.programming.middle;

/**
 * 474. 一和零
 */
public class FindMaxForm_474 {


    private static int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }


    public static int findMaxForm(String[] strs, int m, int n) {

        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (int i = 1; i <= len; i++) {

            int[] c = countZeroAndOne(strs[i - 1]);
            for (int j = 0; j <= m; j++) {

                for (int k = 0; k <= n; k++) {

                    int zero = c[0];
                    int one = c[1];

                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zero && k >= one) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }


    public static void main(String[] args) {
        System.out.println("结果：" + findMaxForm(new String[]{"10", "0001", "11001", "1", "0"}, 5, 3));
    }
}
