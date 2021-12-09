package com.leetcode.tree.medium.hard;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class Binary_Tree_Maximum_Path_Sum_124 {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPath(root);
        return max;
    }


    public int maxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxLeft = Math.max(0, maxPath(root.left));

        int maxRight = Math.max(0, maxPath(root.right));

        max = Math.max(max, maxLeft + maxRight + root.val);

        return root.val + Math.max(maxLeft, maxRight);
    }


    public static void main(String[] args) {

        Binary_Tree_Maximum_Path_Sum_124 method = new Binary_Tree_Maximum_Path_Sum_124();

//        TreeNode root = Deserialize.LevelOrderDeserialize("-10,9,20,#,#,15,7");
        TreeNode root = Deserialize.LevelOrderDeserialize("-5,-10,8,3,12,5,#");
        System.out.println(method.maxPathSum(root));
    }
}


