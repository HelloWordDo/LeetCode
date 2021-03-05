package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 */
public class FindMode_501 {

    static int max = 0;
    static int count = 0;
    static int current = 0;
    static List<Integer> res = new ArrayList<>();

    public static int[] findMode(TreeNode root) {

        findModeList(root);

        int[] a = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            a[i] = res.get(i);
            System.out.print("," + a[i]);
        }
        return a;
    }

    public static void findModeList(TreeNode root) {

        if (root == null) {
            return;
        }
        if (root.left != null) {
            findModeList(root.left);
        }
        int val = root.val;

        if (current == val) {
            ++count;
        } else {
            current = val;
            count = 1;
        }

        if (count == max) {
            res.add(val);
        }
        if (count > max) {
            res.clear();
            res.add(val);
            max = count;
        }
        if (root.right != null) {
            findModeList(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,#,#,2,6");

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,#,#,3,5");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        findMode(treeNode);
        System.out.println();
    }


}
