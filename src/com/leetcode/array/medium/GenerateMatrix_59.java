package com.leetcode.array.medium;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 */
public class GenerateMatrix_59 {

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int i = 0, j = 0;
        int dirt = 0;
        int num = 1;
        while (num < n * n) {

            switch (dirt) {
                case 0:
                    if (j + 1 >= n || matrix[i][j + 1] != 0) {
                        dirt = 1;
                    } else {
                        matrix[i][j] = num;
                        j++;
                        num++;
                    }
                    break;
                case 1:
                    if (i + 1 >= n || matrix[i + 1][j] != 0) {
                        dirt = 2;
                    } else {
                        matrix[i][j] = num;
                        num++;
                        i++;
                    }
                    break;
                case 2:
                    if (j - 1 < 0 || matrix[i][j - 1] != 0) {
                        dirt = 3;
                    } else {
                        matrix[i][j] = num;
                        num++;
                        j--;
                    }
                    break;
                case 3:
                    if (i - 1 < 0 || matrix[i - 1][j] != 0) {
                        dirt = 0;
                    } else {
                        matrix[i][j] = num;
                        num++;
                        i--;
                    }
                    break;
            }
        }

        matrix[i][j] = num;
        return matrix;
    }

    public static void main(String[] args) {

        GenerateMatrix_59 method = new GenerateMatrix_59();
        method.generateMatrix(4);

    }
}
