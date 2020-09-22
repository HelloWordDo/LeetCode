package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 86. 分隔链表
 */
public class Partition_86 {


    public static ListNode partition(ListNode head, int x) {

        ListNode n = new ListNode(-1);
        n.next = head;

        ListNode n2 = n;

        while (n2 != null && n2.next != null && n2.next.val < x) {
            n2 = n2.next;
        }

        ListNode n1 = n2.next;

        while (n1 != null && n1.next != null) {

            if (n1.next.val < x) {

                ListNode temp = n2.next;
                ListNode temp2 = n1.next;

                n2.next = temp2;
                n1.next = n1.next.next;
                temp2.next = temp;
                n2 = n2.next;
            } else {
                n1 = n1.next;
            }
        }

        return n.next;
    }


    public static void main(String[] args) {

        ListNode n1 = new ListNode(3);
        ListNode n2 = n1;
        n2.next = new ListNode(2);
        n2 = n2.next;
        n2.next = new ListNode(1);
//        n2 = n2.next;
//        n2.next = new ListNode(4);
//        n2 = n2.next;
//        n2.next = new ListNode(3);
//        n2 = n2.next;
//        n2.next = new ListNode(2);
//        n2 = n2.next;
//        n2.next = new ListNode(5);
//        n2 = n2.next;
//        n2.next = new ListNode(1);

        partition(n1, 3);
    }
}
