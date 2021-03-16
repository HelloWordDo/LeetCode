package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 653. 两数之和 IV - 输入 BST
 */
public class FindTarget_653 {

    Set set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }


    public static void main(String[] args) {

        TreeNode treeNode = Deserialize.LevelOrderDeserialize("2,#,3,#,4,#,5,#,6");

        FindTarget_653 method = new FindTarget_653();
        System.out.println("结果：" + method.findTarget(treeNode, 5));

    }
}
