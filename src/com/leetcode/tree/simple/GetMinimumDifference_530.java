package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 */
public class GetMinimumDifference_530 {

    static int min = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {

        getMinimumDifference(root, null);
        return min;
    }

    public static TreeNode getMinimumDifference(TreeNode root, TreeNode temp) {

        if (root.left != null) {
            temp = getMinimumDifference(root.left, temp);
        }

        if (temp != null) {
            min = Math.min(min, Math.abs(root.val - temp.val));
        }
        temp = root;

        if (root.right != null) {
            temp = getMinimumDifference(root.right, temp);
        }
        return temp;
    }

    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("7,3,19,0,#,10,21");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,1,#,3,5");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        System.out.println("结果：" + getMinimumDifference(treeNode));
    }
}
