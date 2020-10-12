package com.leetcode.tree.simple;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * 617. 合并二叉树
 */
public class MergeTrees_617 {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        return dfs(t1, t2);

    }

    public static TreeNode dfs(TreeNode t1, TreeNode t2) {

        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if (t1 == null || t2 == null) {

            return t1 == null ? t2 : t1;
        }

        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        t1.val = t1.val + t2.val;
        t1.left = dfs(t1.left, t2.left);
        t1.right = dfs(t1.right, t2.right);

        return t1;
    }


    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {


        if (t1 == null || t2 == null) {

            return t1 == null ? t2 : t1;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();

        linkedList.add(t1);
        linkedList.add(t2);

        while (!linkedList.isEmpty()) {

            TreeNode r1 = linkedList.remove();
            TreeNode r2 = linkedList.remove();

            r1.val = r1.val + r2.val;

            if (r1.left != null && r2.left != null) {

                linkedList.add(r1.left);
                linkedList.add(r2.left);
            } else if (r1.left == null) {
                r1.left = r2.left;
            }

            if (r1.right != null && r2.right != null) {

                linkedList.add(r1.right);
                linkedList.add(r2.right);
            } else if (r1.right == null) {
                r1.right = r2.right;
            }

        }
        return t1;
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);

        t1.left = new TreeNode(10);
        t1.right = new TreeNode(7);

        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(3);

        t1.right.left = new TreeNode(6);
        t1.right.right = new TreeNode(5);

        t1.left.left.left = new TreeNode(9);


        TreeNode t2 = new TreeNode(2);

        t2.left = new TreeNode(5);
        t2.right = new TreeNode(3);

        t2.left.left = new TreeNode(7);
        t2.left.right = new TreeNode(5);

        t2.right.left = new TreeNode(1);
        t2.right.right = new TreeNode(2);

        t2.left.left.left = new TreeNode(4);

        t2.right.left.right = new TreeNode(2);

        TreeNode t = mergeTrees(t1, t2);

        System.out.println(t);
    }
}
