package com.leetcode.tree.simple;

import com.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * 617. 合并二叉树
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意: 合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    /**
     * 2021.7.15
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {

        return dfs2(t1, t2);
    }

    public TreeNode dfs2(TreeNode t1, TreeNode t2) {

        if (t1 == null || t2 == null) {
            if (t1 == null) {
                t1 = t2;
            }
            return t1;
        }

        t1.left = dfs2(t1.left, t2.left);
        t1.right = dfs2(t1.right, t2.right);

        t1.val = t1.val + t2.val;

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

        MergeTrees_617 method = new MergeTrees_617();
        TreeNode t = method.mergeTrees3(t1, t2);

        System.out.println(t);
    }
}
