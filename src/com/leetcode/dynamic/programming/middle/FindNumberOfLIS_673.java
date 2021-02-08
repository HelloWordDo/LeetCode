package com.leetcode.dynamic.programming.middle;

/**
 * 673. 最长递增子序列的个数
 */
public class FindNumberOfLIS_673 {

    public static int findNumberOfLIS(int[] nums) {

        if (nums.length == 0) return 0;
        //第i有多少个递增种类
        int[] type = new int[nums.length];

        //第i有多少个递增数字
        int[] len = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {

            len[i] = 1;
            type[i] = 1;
            for (int j = 0; j < i; j++) {

                int a = nums[i];
                int b = nums[j];
                if (a > b) {
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        type[i] = type[j];
                    } else if (len[i] == len[j] + 1) {
                        type[i] += type[j];
                    }
                }
            }
            max = Math.max(max, len[i]);//找出最长递增子序列的长度是多少
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (len[i] == max) {
                ans += type[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + findNumberOfLIS(new int[]{1, 3, 7, 2, 5, 4, 7, 3}));
    }
}
