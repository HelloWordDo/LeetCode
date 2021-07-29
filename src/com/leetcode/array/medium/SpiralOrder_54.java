package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class SpiralOrder_54 {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        int i = 0, j = 0;
        int direction = 0;

        while (i < m && j >= 0 && !visited[i][j]) {

            visited[i][j] = true;
            res.add(matrix[i][j]);

            switch (direction) {
                case 0:
                    if (j + 1 >= n || visited[i][j + 1]) {
                        direction = 1;
                        i++;
                    } else if (!visited[i][j + 1]) {
                        j++;
                    }
                    break;
                case 1:
                    if (i + 1 >= m || visited[i + 1][j]) {
                        direction = 2;
                        j--;
                    } else if (!visited[i + 1][j]) {
                        i++;
                    }
                    break;
                case 2:
                    if (j - 1 < 0 || visited[i][j - 1]) {
                        direction = 3;
                        i--;
                    } else if (!visited[i][j - 1]) {
                        j--;
                    }
                    break;
                case 3:
                    if (i - 1 < 0 || visited[i - 1][j]) {
                        direction = 0;
                        j++;
                    } else if (!visited[i - 1][j]) {
                        i--;
                    }
                    break;
            }

        }
        return res;
    }


    public static void main(String[] args) {

        SpiralOrder_54 method = new SpiralOrder_54();
//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8,}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] matrix = new int[][]{{1}, {2}, {3}};
        List<Integer> list = method.spiralOrder(matrix);

        System.out.println(list);
    }


}
