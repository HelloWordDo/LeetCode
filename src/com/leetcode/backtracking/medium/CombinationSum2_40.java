package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 给定一个数组  candidates  和一个目标数  target  ，找出  candidates  中所有可以使数字和为  target  的组合。
 * <p>
 * candidates  中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例  1:
 * <p>
 * 输入: candidates =  [10,1,2,7,6,1,5], target =  8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例  2:
 * <p>
 * 输入: candidates =  [2,5,2,1,2], target =  5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum2_40 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<Integer> track = new ArrayList<>();

        Arrays.sort(candidates);
        backtrack(candidates, track, target, 0);

        return res;
    }

    private void backtrack(int[] candidates, List<Integer> track, int target, int index) {

        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            int data = candidates[i];

            //排序后大剪枝
            if (target - data < 0) {
                break;
            }

            if (index < i && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.add(data);
            backtrack(candidates, track, target - data, ++i);

            --i;
            track.remove(track.size() - 1);

        }
    }

    public static void main(String[] args) {

        CombinationSum2_40 method = new CombinationSum2_40();
        method.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }
}
