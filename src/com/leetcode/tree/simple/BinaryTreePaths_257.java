package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths_257 {

    private static List<String> res = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        binaryTreePaths(root, "");
        return res;
    }


    public static String binaryTreePaths(TreeNode root, String s) {

        if ("".equals(s)) {
            s = s + root.val;
        } else {
            s = s + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            res.add(s);
            return "";
        }

        if (root.left != null) {
            binaryTreePaths(root.left, s);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, s);
        }

        return s;
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,1,#,3,5");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        System.out.println("结果：" + binaryTreePaths(treeNode));
    }
}
