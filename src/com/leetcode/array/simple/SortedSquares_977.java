package com.leetcode.array.simple;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class SortedSquares_977 {

    public int[] sortedSquares(int[] nums) {

        int i = nums.length - 1, j = 0;

        for (int k = 0; k < nums.length - 1; k++) {
            if (Math.abs(nums[k]) >= Math.abs(nums[k + 1])) {
                continue;
            }
            i = k;
            break;
        }
        j = i + 1;

        int[] res = new int[nums.length];
        int index = 0;

        while (i >= 0 && j < nums.length) {
            if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                res[index] = nums[i] * nums[i];
                index++;
                i--;
            } else if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[index] = nums[j] * nums[j];
                index++;
                j++;
            }
        }

        if (i >= 0) {
            for (int k = i; k >= 0; k--) {
                res[index] = nums[k] * nums[k];
                index++;
            }
        }

        if (j < nums.length) {
            for (int k = j; k < nums.length; k++) {
                res[index] = nums[k] * nums[k];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        SortedSquares_977 method = new SortedSquares_977();
        System.out.println(method.sortedSquares(new int[]{-4, -4, -3}));
    }
}
