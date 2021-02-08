package com.leetcode.dynamic.programming.middle;

/**
 * 523. 连续的子数组和
 */
public class CheckSubarraySum_523 {

    public static boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            int sum = 0;
            for (int j = i; j < nums.length; j++) {

                if (i == j) {
                    sum = nums[i];
                    continue;
                }
                sum = sum + nums[j];

                if (k == 0) {
                    if (sum != 0) continue;
                    if (sum == 0) return true;
                }
                if (sum % k == 0) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println("结果：" + checkSubarraySum(new int[]{1, 2, 3}, 3));
    }
}
