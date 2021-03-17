package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 671. 二叉树中第二小的节点
 */
public class FindSecondMinimumValue_671 {

    public int findSecondMinimumValue(TreeNode root) {

        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        int left = root.left.val, right = root.right.val;

        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left == root.val && right == root.val) {
            return -1;
        }

        return Math.min(left, right) > root.val ? Math.min(left, right) : Math.max(left, right);
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize
                .LevelOrderDeserialize("1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1,#,#,#,#,#,#,#,#,#,#");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("2,2,10,3,2,11,10");

        FindSecondMinimumValue_671 method = new FindSecondMinimumValue_671();
        System.out.println("结果：" + method.findSecondMinimumValue(treeNode));

    }
}
