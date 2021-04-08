package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum_39 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> track = new ArrayList<>();
        backtrack(candidates, track, target, 0);

        return res;
    }

    void backtrack(int[] nums, List<Integer> track, int target, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i < nums.length; i++) {

            int data = nums[i];

            if (target - data < 0) {
                continue;
            }
            track.add(data);

            backtrack(nums, track, target - data, i);

            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {

        CombinationSum_39 method = new CombinationSum_39();
        List<List<Integer>> l = method.combinationSum(new int[]{2, 3, 5}, 8);
    }
}
