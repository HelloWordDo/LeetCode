package com.leetcode.dynamic.programming;

/**
 * 63. 不同路径 II
 */
public class UniquePathsWithObstacles_63 {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] p = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    p[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    p[i][j] = 1;
                } else if (i == 0) {
                    p[i][j] = p[i][j - 1];
                } else if (j == 0) {
                    p[i][j] = p[i - 1][j];
                } else {
                    p[i][j] = p[i][j - 1] + p[i - 1][j];
                }
            }
        }

        return p[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println("结果：" + uniquePathsWithObstacles(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}
