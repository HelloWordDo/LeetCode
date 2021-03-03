package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 112. 路径总和
 */
public class HasPathSum_112 {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, 0);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum, int count) {

        if (root == null) {
            return false;
        }
        boolean left = false, right = false;

        int val = root.val;

        count = count + val;

        if (root.left == null && root.right == null && targetSum == count) {

            return true;
        }

        if (root.left != null || root.right != null) {

            left = hasPathSum(root.left, targetSum, count);
            right = hasPathSum(root.right, targetSum, count);
        }

        return left || right;
    }

    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("5,4,8,11,#,13,4,7,2,#,#,#,1");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        System.out.println("结果：" + hasPathSum(treeNode, -2));

    }
}
