package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 876. 链表的中间结点
 */
public class MiddleNode_876 {

    public static ListNode middleNode(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(3);
        n2 = n2.next;
        n2.next = new ListNode(4);
        n2 = n2.next;
        n2.next = new ListNode(5);

        middleNode(n1);
    }
}
