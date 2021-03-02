package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 111. 二叉树的最小深度
 */
public class MinDepth_111 {

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null || root.right == null) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("2,#,3,#,4,#,5,#,6");

        System.out.println("结果：" + minDepth(treeNode));

    }
}
