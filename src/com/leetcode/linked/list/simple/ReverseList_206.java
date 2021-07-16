package com.leetcode.linked.list.simple;

import com.leetcode.linked.list.ListNode;

/**
 * 206. 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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


    /**
     * 2021.07.16
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseList2(head.next);

        head.next.next = head;
        head.next = null;
        return node;
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

//        reverseList(n1);

        ReverseList_206 method = new ReverseList_206();
        method.reverseList2(n1);
    }
}
