package com.leetcode.dynamic.programming;

/**
 * 304.二维区域和检索 - 矩阵不可变
 */
public class NumMatrix_304 {

    int[][] dp;

    public NumMatrix_304(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            dp = null;
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (i == 0 && j != 0) {
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
                    continue;
                }
                if (j == 0 && i != 0) {
                    dp[i][j] = matrix[i][j] + dp[i - 1][j];
                    continue;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i][j];
                }
            }
        }

        System.out.println(dp);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        if (dp == null) {
            return 0;
        }
        if (row1 == 0 && col1 == 0 && row2 == 0 && col2 == 0) {
            return dp[0][0];
        }
        if (row1 == 0 && col1 == 0 && ((row1 == 0 && row2 == 0) || (col1 == 0 && col2 == 0))) {
            return dp[row2][col2];
        }

        int range = dp[row2][col2];

        if (col1 - 1 >= 0) {
            range = range - dp[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            range = range - dp[row1 - 1][col2];
        }
        if (row1 - 1 >= 0 && col1 - 1 >= 0) {
            range = range + dp[row1 - 1][col1 - 1];
        }
        return range;
//        return dp[row2][col2] - dp[row1 - 1][col2] - dp[row2][col1 - 1] + dp[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {

//        int[][] matrix = new int[5][5];
//
//        matrix[0] = new int[]{3, 0, 1, 4, 2};
//        matrix[1] = new int[]{5, 6, 3, 2, 1};
//        matrix[2] = new int[]{1, 2, 0, 1, 5};
//        matrix[3] = new int[]{4, 1, 0, 1, 7};
//        matrix[4] = new int[]{1, 0, 3, 0, 5};

//        int[][] matrix = new int[4][0];
//
//        matrix[0] = new int[]{7, 7, 0};
//        matrix[1] = new int[]{-4, -7, 7};
//        matrix[2] = new int[]{-4, 0, -2};
//        matrix[3] = new int[]{-8, -5, 6};
//        matrix[4] = new int[]{1, 0, 3, 0, 5};

        int[][] matrix = new int[1][0];
        matrix[0] = new int[]{-4, -5};

        NumMatrix_304 obj = new NumMatrix_304(matrix);
        int param_1 = obj.sumRegion(0, 1, 0, 1);
//[[[[7,7,0],[-4,-7,7],[-4,0,-2],[-8,-5,6]]],[1,0,2,2],[3,2,3,2],[2,1,2,2],[0,2,2,2],[3,2,3,2]]
        System.out.println("结果：" + param_1);
    }
}
