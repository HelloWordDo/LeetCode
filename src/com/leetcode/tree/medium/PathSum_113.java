package com.leetcode.tree.medium;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum_113 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        LinkedList<Integer> backtrack = new LinkedList<>();
        pathSum(backtrack, root, targetSum, 0);

        return res;
    }

    public void pathSum(LinkedList<Integer> backtrack, TreeNode root, int targetSum, int curSum) {

        if (root == null) {
            return;
        }

        backtrack.add(root.val);

        curSum += root.val;
        if (root.left == null && root.right == null) {

            if (curSum == targetSum) {
                res.add(new ArrayList<>(backtrack));
            }
            backtrack.removeLast();
            return;
        }

        pathSum(backtrack, root.left, targetSum, curSum);

        pathSum(backtrack, root.right, targetSum, curSum);

        backtrack.removeLast();
    }

    public static void main(String[] args) {

        PathSum_113 method = new PathSum_113();

        TreeNode root = Deserialize.LevelOrderDeserialize("5,4,8,11,#,13,4,7,2,#,#,5,1");

        List<List<Integer>> res = method.pathSum(root, 22);

        System.out.println(res);
    }
}
