package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode_160 {


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
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


        ListNode n3 = new ListNode(5);
        ListNode n4 = n3;
        n4.next = new ListNode(6);
        n4 = n4.next;
        n4.next = new ListNode(1);
        n4 = n4.next;
        n4.next = new ListNode(8);
        n4 = n4.next;
        n4.next = new ListNode(7);
        n4 = n4.next;
        n4.next = new ListNode(5);

        getIntersectionNode(n1, n3);
    }
}
