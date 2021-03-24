package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 */
public class SearchBST_700 {

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            root = searchBST(root.left, val);
        } else if (root.val < val) {
            root = searchBST(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {

//        TreeNode treeNode = Deserialize.LevelOrderDeserialize("4,2,7,1,3,#,#");
        TreeNode treeNode = Deserialize.LevelOrderDeserialize("40,20,60,10,30,50,70");

        SearchBST_700 searchBST_700 = new SearchBST_700();
        TreeNode t = searchBST_700.searchBST(treeNode, 100);

        System.out.println("结果:" + t);
    }
}
