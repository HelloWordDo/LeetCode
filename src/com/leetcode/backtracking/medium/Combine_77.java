package com.leetcode.backtracking.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 * <p>
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine_77 {

    List<List<Integer>> res = new ArrayList();

    public List<List<Integer>> combine(int n, int k) {

        Deque<Integer> track = new ArrayDeque<>();
        backtrack(n, k, track, 1);
        return res;
    }

    void backtrack(int n, int k, Deque<Integer> track, int depth) {

        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = depth; i <= n; i++) {

            track.add(i);
            backtrack(n, k, track, ++depth);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        Combine_77 method = new Combine_77();
        method.combine(4, 2);
    }
}
