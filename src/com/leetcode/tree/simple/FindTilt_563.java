package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 563. 二叉树的坡度
 */
public class FindTilt_563 {

    int tilt = 0;

    public int findTilt(TreeNode root) {
        tilt(root);
        return tilt;
    }

    public int tilt(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = tilt(root.left);
        int right = tilt(root.right);
        tilt += Math.abs(left - right);

        return left + right + root.val;
    }


    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize
//                .LevelOrderDeserialize("1,2,3,4,5,#,#,7,8,6,9,10,11,#,#,12,13,#,#,14,#,#,#,#,#,#,#");
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("4,2,9,3,5,#,7");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        FindTilt_563 findTilt_563 = new FindTilt_563();
        System.out.println("结果：" + findTilt_563.findTilt(treeNode));
    }
}
