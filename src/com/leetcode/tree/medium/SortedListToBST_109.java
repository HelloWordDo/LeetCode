package com.leetcode.tree.medium;

import com.leetcode.linked.list.ListNode;
import com.leetcode.tree.Serialize;
import com.leetcode.tree.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点  的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * <p>
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST_109 {

    ListNode listNode;

    public TreeNode sortedListToBST(ListNode head) {

        listNode = head;

        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return sortedListToBST(0, i - 1);
    }


    public TreeNode sortedListToBST(int left, int right) {

        if (left > right) {
            return null;
        }
        int mid = (right + left + 1) / 2;

        TreeNode node = new TreeNode();

        System.out.println(node.val + " " + left + " " + mid + " " + right);
        node.left = sortedListToBST(left, mid - 1);
        node.val = listNode.val;
        listNode = listNode.next;
        node.right = sortedListToBST(mid + 1, right);

        return node;
    }


    public static void main(String[] args) {

        SortedListToBST_109 method = new SortedListToBST_109();

        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        TreeNode node = method.sortedListToBST(head);

        System.out.println(Serialize.serialize(node));
    }
}
