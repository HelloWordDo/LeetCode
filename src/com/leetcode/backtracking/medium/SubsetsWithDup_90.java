package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup_90 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        LinkedList<Integer> track = new LinkedList<>();

        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            backtrack(nums, track, i, 0);
        }
        return res;
    }


    public void backtrack(int[] nums, LinkedList<Integer> track, int count, int index) {

        if (track.size() == count) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = index; i < nums.length; i++) {

            if (index < i && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, track, count, i + 1);
            track.removeLast();
        }
    }


    public static void main(String[] args) {

        SubsetsWithDup_90 method = new SubsetsWithDup_90();

        List<List<Integer>> list = method.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println("结果：" + list);
    }
}
