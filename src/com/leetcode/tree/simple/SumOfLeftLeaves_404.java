package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 404. 左叶子之和
 */
public class SumOfLeftLeaves_404 {

    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        return sumOfLeftLeaves(root, 0);
    }

    public static int sumOfLeftLeaves(TreeNode root, int res) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            res += root.val;
        }

        if (root.left != null) {
            res = sumOfLeftLeaves(root.left, res);
        }

        if (root.right != null) {
            root.right.val = 0;
            res = sumOfLeftLeaves(root.right, res);
        }
        return res;
    }


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(0);

        treeNode.left = new TreeNode(-4);
        treeNode.right = new TreeNode(-3);

        treeNode.left.right = new TreeNode(-1);
        treeNode.right.left = new TreeNode(8);

        treeNode.left.right.right = new TreeNode(3);
        treeNode.right.left.right = new TreeNode(9);

        treeNode.left.right.right.left = new TreeNode(-2);
        treeNode.right.left.right.left = new TreeNode(4);


        treeNode = Deserialize.LevelOrderDeserialize("0,-4,-3,#,-1,8,#,#,3,#,9,-2,1,4,#,#,#,#,#");

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,#,#,3,5");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");


        System.out.println("结果：" + sumOfLeftLeaves(treeNode));
    }
}
