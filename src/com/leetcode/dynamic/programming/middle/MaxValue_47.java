package com.leetcode.dynamic.programming.middle;

/**
 * 面试题47. 礼物的最大价值
 */
public class MaxValue_47 {

    public static int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] m = new int[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (i == 0 && j == 0) {
                    m[0][0] = grid[0][0];
                    continue;
                }
                if (i == 0) {
                    m[0][j] = m[0][j - 1] + grid[0][j];
                    continue;
                }

                if (j == 0) {
                    m[i][0] = m[i - 1][0] + grid[i][0];
                    continue;
                }
                m[i][j] = Math.max(m[i - 1][j], m[i][j - 1]) + grid[i][j];
            }
        }
        return m[row - 1][col - 1];
    }

    public static void main(String[] args) {

        int[][] c = new int[3][3];

        c[0] = new int[]{1, 3, 1};
        c[1] = new int[]{1, 5, 1};
        c[2] = new int[]{4, 2, 1};

        System.out.println("结果：" + maxValue(c));
    }

}
