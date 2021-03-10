package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 543. 二叉树的直径
 */
public class DiameterOfBinaryTree_543 {

    static int path = 0;

    public static int diameterOfBinaryTree(TreeNode root) {

        diameterOfBinaryTree(root, 0, 0);
        return path;
    }

    public static int diameterOfBinaryTree(TreeNode root, int leftPath, int rightPath) {

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        leftPath = diameterOfBinaryTree(root.left, leftPath, rightPath);

        rightPath = diameterOfBinaryTree(root.right, leftPath, rightPath);

        if (root.left != null) {
            ++leftPath;
        }
        if (root.right != null) {
            ++rightPath;
        }

        path = Math.max(path, leftPath + rightPath);

        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {

        TreeNode treeNode = Deserialize
                .LevelOrderDeserialize("1,2,3,4,5,#,#,7,8,6,9,10,11,#,#,12,13,#,#,14,#,#,#,#,#,#,#");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,#");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        System.out.println("结果：" + diameterOfBinaryTree(treeNode));
    }
}
