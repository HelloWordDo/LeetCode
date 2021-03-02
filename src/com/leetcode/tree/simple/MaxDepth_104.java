package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 */
public class MaxDepth_104 {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return maxDepth2(root, 0);
    }

    public static int maxDepth2(TreeNode root, int max) {

        if (root == null) {
            return max;
        }
        int count = max;
        int a = maxDepth2(root.left, count + 1);

        int b = maxDepth2(root.right, count + 1);

        return Math.max(a, b);
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,2,3,4,4,3,9,#,9,#,#,#,#,#");
        int b = maxDepth(treeNode);

        System.out.println("结果：" + b);
    }
}
