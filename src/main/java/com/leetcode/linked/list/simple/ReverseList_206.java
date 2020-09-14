package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 206. 反转链表
 */
public class ReverseList_206 {

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode n = p.next;
        p.next = null;

        while (n != null) {

            ListNode temp = n.next;
            n.next = p;
            p = n;
            n = temp;
        }

        return p;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = n1;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(8);
        n2 = n2.next;
        n2.next = new ListNode(7);
        n2 = n2.next;
        n2.next = new ListNode(5);

        reverseList(n1);
    }
}
