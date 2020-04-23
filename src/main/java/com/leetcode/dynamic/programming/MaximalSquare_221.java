package com.leetcode.dynamic.programming;

/**
 * 221. 最大正方形
 */
public class MaximalSquare_221 {

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        int maxLen = dp[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        dp[0][j] = 1;
                        continue;
                    }
                    if (j == 0) {
                        dp[i][0] = 1;
                        continue;
                    }
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        char[][] c = new char[4][5];

        c[0] = new char[]{1, 0, 1, 0, 0};
        c[1] = new char[]{1, 1, 1, 1, 1};
        c[2] = new char[]{1, 1, 1, 1, 1};
        c[3] = new char[]{1, 1, 1, 1, 0};

        System.out.println("结果：" + maximalSquare(c));
    }
}
