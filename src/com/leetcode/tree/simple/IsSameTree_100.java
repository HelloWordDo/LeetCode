package com.leetcode.tree.simple;

import com.leetcode.tree.TreeNode;

/**
 * 100. 相同的树
 */
public class IsSameTree_100 {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if ((p != null && q == null) || (p == null && q != null) || (p.val != q.val)) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public static void main(String[] args) {

        TreeNode t1 = new TreeNode(1);

        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);

//        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(3);
//
        t1.right.left = new TreeNode(6);
//        t1.right.right = new TreeNode(5);
//
//        t1.left.left.left = new TreeNode(9);


        TreeNode t2 = new TreeNode(1);

        t2.left = new TreeNode(2);
        t2.right = new TreeNode(3);

//        t2.left.left = new TreeNode(7);
        t2.left.right = new TreeNode(3);
//
//        t2.right.left = new TreeNode(1);
//        t2.right.right = new TreeNode(2);
//
//        t2.left.left.left = new TreeNode(4);
//
//        t2.right.left.right = new TreeNode(2);

        Boolean b = isSameTree(t1, t2);

        System.out.println("结果：" + b);
    }
}
