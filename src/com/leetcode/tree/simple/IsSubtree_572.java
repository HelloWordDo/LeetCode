package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 572. 另一个树的子树
 */
public class IsSubtree_572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s, t);
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        }

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }


    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize
//                .LevelOrderDeserialize("1,2,3,4,5,#,#,7,8,6,9,10,11,#,#,12,13,#,#,14,#,#,#,#,#,#,#");
        TreeNode s = Deserialize.LevelOrderDeserialize("3,4,4,5,2,2,2");
        TreeNode t = Deserialize.LevelOrderDeserialize("4,1,2");

        IsSubtree_572 isSubtree_572 = new IsSubtree_572();
        System.out.println("结果：" + isSubtree_572.isSubtree(s, t));
    }
}
