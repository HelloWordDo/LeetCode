package com.leetcode.array.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Longest_Consecutive_Sequence_128 {

    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> visited = new HashSet();

        for (int i = 0; i < nums.length; i++) {

            map.put(nums[i], 1);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            if (visited.contains(num)) {
                continue;
            }

            int count = 1;
            int indexLeft = num;
            int indexRight = num;
            visited.add(num);

            int left = map.getOrDefault(--indexLeft, 0);
            int right = map.getOrDefault(++indexRight, 0);

            while (left != 0) {

                count++;
                visited.add(indexLeft);
                left = map.getOrDefault(--indexLeft, 0);
            }

            while (right != 0) {

                count++;
                visited.add(indexRight);
                right = map.getOrDefault(++indexRight, 0);
            }
            max = Math.max(count, max);

        }
        return max;
    }

    public static void main(String[] args) {

        Longest_Consecutive_Sequence_128 method = new Longest_Consecutive_Sequence_128();

//        System.out.println(method.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(method.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
