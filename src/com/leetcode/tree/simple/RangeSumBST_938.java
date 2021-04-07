package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 */
public class RangeSumBST_938 {

    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) {
            return 0;
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = Deserialize.LevelOrderDeserialize("5,3,6,2,4,#,8,1,#,#,#,7,9");

        RangeSumBST_938 method = new RangeSumBST_938();

        System.out.println("结果：" + method.rangeSumBST(treeNode1, 3, 7));
    }
}
