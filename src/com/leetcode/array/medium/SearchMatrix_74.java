package com.leetcode.array.medium;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class SearchMatrix_74 {

    public boolean searchMatrix(int[][] matrix, int target) {

        int targetRow = 0;
        if (target > matrix[matrix.length - 1][matrix[0].length - 1] || target < matrix[0][0]) {
            return false;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        while (rowStart <= rowEnd) {
            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (matrix[mid][0] > target) {
                targetRow = mid - 1;
                rowEnd = mid - 1;
            } else if (matrix[mid][0] <= target) {

                if (matrix[mid][matrix[0].length - 1] < target) {
                    targetRow = mid + 1;
                    rowStart = mid + 1;
                } else {
                    targetRow = mid;
                    break;
                }
            }
            if (targetRow == 0 || target == matrix.length) {
                break;
            }
        }

        System.out.println(targetRow);

        int[] num = matrix[targetRow];

        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else if (num[mid] == target) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {

        SearchMatrix_74 method = new SearchMatrix_74();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(method.searchMatrix(matrix, 60));
    }
}
