package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 110. 平衡二叉树
 */
public class IsBalanced_110 {

    public static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }
        return avt(root) != -1;
    }

    public static int avt(TreeNode tree) {

        if (tree == null) {
            return 0;
        }

        int leftHigh = avt(tree.left);

        if (leftHigh == -1) {
            return -1;
        }

        int rightHigh = avt(tree.right);

        if (rightHigh == -1) {
            return -1;
        }

        return Math.abs(leftHigh - rightHigh) < 2 ? Math.max(leftHigh, rightHigh) + 1 : -1;
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,2,3,3,#,#,4,4,#,#,#,#,#,#");
        boolean b = isBalanced(treeNode);

        System.out.println("结果：" + b);

    }
}
