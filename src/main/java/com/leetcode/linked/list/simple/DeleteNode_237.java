package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 237. 删除链表中的节点
 */
public class DeleteNode_237 {

    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(1);

        deleteNode(n1);
    }
}
