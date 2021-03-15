package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 606. 根据二叉树创建字符串
 */
public class Tree2str_606 {

    String res = "";

    public String tree2str(TreeNode t) {

        if (t == null) {
            return res;
        }
        helper(t);
        return res;
    }

    public String helper(TreeNode t) {

        res = res + t.val + "";

        if (t.left == null && t.right != null) {
            res += "()";
        }

        if (t.left != null) {
            res += "(";
            helper(t.left);
            res += ")";
        }

        if (t.right != null) {
            res += "(";
            helper(t.right);
            res += ")";
        }
        return res;
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,2,3,4,#");
        Tree2str_606 tree2str_606 = new Tree2str_606();

        System.out.println("结果：" + tree2str_606.tree2str(treeNode));
    }
}
