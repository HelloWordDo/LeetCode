package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[]
 */
public class FourSum_18 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if ((i > 0 && nums[i] == nums[i - 1]) || (j > i + 1 && nums[j] == nums[j - 1])) {
                    continue;
                }

                if (nums.length - i < 4) {
                    continue;
                }

                int l = j + 1;
                int r = nums.length - 1;

                int s1 = nums[i] + nums[j];
                while (l < r) {

                    if (s1 + nums[l] + nums[r] == target) {

                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (s1 + nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        FourSum_18 method = new FourSum_18();

        List<List<Integer>> res = method.fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0);
        System.out.println(res);
    }
}
