package com.leetcode.dynamic.programming.middle;

/**
 * 698. 划分为k个相等的子集
 */
public class CanPartitionKSubsets_698 {

    public static boolean canPartitionKSubsets(int[] nums, int k) {

        int target, sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        target = sum / k;

        if (sum % k != 0 || max > target) {
            return false;
        }
        boolean[] used = new boolean[nums.length];
        return backtracking(nums, k, target, 0, 0, used);
    }


    public static boolean backtracking(int[] nums, int k, int target, int cur, int start, boolean[] used) {

        //最终分组为0，则完全划分成功
        if (k == 0) {
            return true;
        }
        if (cur == target) {
            //去找剩下的分组（k-1）个
            return backtracking(nums, k - 1, target, 0, 0, used);
        }

        for (int i = start; i < nums.length; i++) {

            if (!used[i] && nums[i] + cur <= target) {

                used[i] = true;
                if (backtracking(nums, k, target, nums[i] + cur, i + 1, used)) {
                    return true;
                } else {
                    used[i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 5}, 4));
    }
}
