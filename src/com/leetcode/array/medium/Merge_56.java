package com.leetcode.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Merge_56 {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, ((a, b) -> {

            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        }));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List res = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {

            int s1 = intervals[i][0];
            int s2 = intervals[i][1];
            if (s1 <= end && s2 >= end) {

                //合并
                end = s2;
            } else if (s1 > end) {
                res.add(new int[]{start, end});
                start = s1;
                end = s2;
            }
        }

        res.add(new int[]{start, end});
        return (int[][]) res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        Merge_56 method = new Merge_56();
        int[][] m = method.merge(new int[][]{{1, 3}, {8, 10}, {15, 18}});
        System.out.println(m);
    }
}
