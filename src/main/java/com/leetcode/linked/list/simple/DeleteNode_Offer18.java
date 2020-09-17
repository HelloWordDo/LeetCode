package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class DeleteNode_Offer18 {

    public static ListNode deleteNode(ListNode head, int val) {

        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode l = node;
        while (l != null && l.next != null) {

            while (l.next != null && l.next.val == val) {
                l.next = l.next.next;
            }
            l = l.next;
        }
        return node.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(5);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(2);

        deleteNode(n1, 5);
    }
}
