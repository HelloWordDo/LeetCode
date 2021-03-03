package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor_235 {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }


    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("-2,#,-3");
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("6,2,8,0,4,7,9,#,#,3,5");
//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("1,-2,-3,1,3,-2,#,-1,#,#,#,#,#");

        String s = Serialize.serialize(lowestCommonAncestor(treeNode, new TreeNode(3), new TreeNode(5)));

        System.out.println("结果：" + s);
    }
}
