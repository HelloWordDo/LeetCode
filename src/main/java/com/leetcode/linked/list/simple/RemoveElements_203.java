package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 203. 移除链表元素
 */
public class RemoveElements_203 {

    public static ListNode removeElements(ListNode head, int val) {


        ListNode l = new ListNode(-1);
        l.next = head;
        ListNode i = l;
        while (i != null && i.next != null) {

            while (i.next != null && i.next.val == val) {
                i.next = i.next.next;
            }
            i = i.next;
        }

        return l.next;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(4);
        ListNode n2 = n1;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);
        n2 = n2.next;
        n2.next = new ListNode(1);

        removeElements(n1, 1);
    }
}
