package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique_47 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, track, visited);
        return res;
    }

    void backtrack(int[] nums, List<Integer> track, boolean[] visited) {

        if (track.size() == nums.length) {

            if (res.contains(track)) {
                return;
            }
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            int data = nums[i];

            track.add(data);
            visited[i] = true;

            backtrack(nums, track, visited);
            visited[i] = false;
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {

        PermuteUnique_47 method = new PermuteUnique_47();
        method.permuteUnique(new int[]{2, 2, 3});
    }
}
