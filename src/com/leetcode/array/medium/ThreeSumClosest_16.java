package com.leetcode.array.medium;

import java.util.Arrays;
import java.util.List;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int value = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - value);

        for (int i = 0; i < nums.length; i++) {

            int l = i + 1;
            int r = nums.length - 1;
            if (r - i < 2) {
                return value;
            }

            while (l < r) {

                int v = nums[i] + nums[l] + nums[r];
                int diff = Math.abs(target - v);
                if (v == target) {
                    return v;
                } else if (v < target) {
                    l++;
                } else if (v > target) {
                    r--;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    value = v;
                }
            }
        }

        return value;
    }


    public static void main(String[] args) {
        ThreeSumClosest_16 method = new ThreeSumClosest_16();
//        List<List<Integer>> res = method
//                .threeSum(new int[]{34, 55, 79, 28, 46, 33, 2, 48, 31, -3, 84, 71, 52, -3, 93, 15, 21, -43, 57, -6, 86, 56, 94, 74, 83, -14, 28, -66, 46, -49, 62, -11, 43, 65, 77, 12, 47, 61, 26, 1, 13, 29, 55, -82, 76, 26, 15, -29, 36, -29, 10, -70, 69, 17, 49});

        int res = method.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(res);
    }
}
