package com.leetcode.graph.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class CanFinish_207 {

    boolean[] path;
    boolean[] visited;
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {

            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }

        path = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < graph.length; i++) {
            backtrack(graph, i);
        }

        return !hasCycle;
    }


    void backtrack(List<Integer>[] graph, int i) {

        if (path[i]) {
            hasCycle = true;
        }
        if (visited[i] || hasCycle) {
            return;
        }

        path[i] = true;
        visited[i] = true;
        for (Integer index : graph[i]) {
            backtrack(graph, index);
        }
        path[i] = false;
    }

    public static void main(String[] args) {

        CanFinish_207 method = new CanFinish_207();
        System.out.println(method.canFinish(5, new int[][]{{0, 1}, {2, 1}, {3, 1}, {4, 3}, {1, 4}}));
    }
}
