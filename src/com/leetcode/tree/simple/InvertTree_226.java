package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

/**
 * 226. 翻转二叉树
 */
public class InvertTree_226 {

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;

        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("5,4,8,11,#,13,4,7,2,#,#,#,1");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        String s = Serialize.serialize(invertTree(treeNode));

        System.out.println("结果：" + s);
    }
}
