package com.leetcode.dynamic.programming.middle;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class CanJump_55 {

    /**
     * i = 0 dp[0] = true
     * i = 1 j = 0 dp[1] = dp[0] && num[0] >= 1
     * <p>
     * i = 2 j = 0 dp[2] = dp[0] && num[0] >= 2
     * i = 2 j = 1 dp[2] = dp[1] && num[1] >= 1
     * <p>
     * i = 3 j = 0 dp[3] = dp[2] && num[2] >= 3
     * i = 3 j = 1 dp[3] = dp[1] && num[1] >= 2
     * i = 3 j = 2 dp[3] = dp[2] && num[2] >= 1
     * ...
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];

        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                dp[i] = dp[i] || (dp[j] && nums[j] >= i - j);
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        CanJump_55 method = new CanJump_55();

//        System.out.println(method.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(method.canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
