package com.leetcode.tree.simple;

import com.leetcode.tree.Deserialize;
import com.leetcode.tree.TreeNode;

import java.util.LinkedList;

/**
 * 872. 叶子相似的树
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root1 = [1], root2 = [1]
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root1 = [1], root2 = [2]
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：root1 = [1,2], root2 = [2,2]
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeafSimilar_872 {

    LinkedList linkedList1 = new LinkedList();

    LinkedList linkedList2 = new LinkedList();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        leafSimilar(root1, linkedList1);

        leafSimilar(root2, linkedList2);

        if (linkedList1.size() != linkedList2.size()) {
            return false;
        }

        for (int i = 0; i < linkedList1.size(); i++) {
            if (linkedList1.get(i) != linkedList2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void leafSimilar(TreeNode root, LinkedList linkedList) {

        if (root.left != null) {
            leafSimilar(root.left, linkedList);
        }

        if (root.right != null) {
            leafSimilar(root.right, linkedList);
        }

        if (root.left == null && root.right == null) {

            linkedList.add(root.val);
        }

    }


    public static void main(String[] args) {

        TreeNode treeNode1 = Deserialize.LevelOrderDeserialize("1,2,3");
        TreeNode treeNode2 = Deserialize.LevelOrderDeserialize("2,3,2");

        LeafSimilar_872 method = new LeafSimilar_872();

        System.out.println("结果：" + method.leafSimilar(treeNode1, treeNode2));
    }
}
