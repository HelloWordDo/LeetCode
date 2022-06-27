package com.leetcode.linked.list.middle;

import com.leetcode.linked.list.ListNode;

/**
 * 148. 排序链表
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围[0, 5 * 104]内
 * -105<= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sort_List_148 {

    /**
     * 超出时间限制
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        ListNode a = new ListNode(-1);
        a.next = head;
        ListNode end = null;

        while (a != null) {
            ListNode b = a.next;
            ListNode p = a;
            while (b != null && b.next != null) {
                ListNode c = b.next;
                if (c == end) {
                    break;
                }
                if (b.val > c.val) {
                    b.next = c.next;
                    c.next = b;
                    p.next = c;
                } else {
                    b = b.next;
                }
                p = p.next;
            }
            end = b;
            if (p == a) {
                return a.next;
            }
        }
        return a.next;
    }

    public ListNode sortList2(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode h = slow.next;
        slow.next = null;

        ListNode left = sortList2(head);
        ListNode right = sortList2(h);

        ListNode res = new ListNode(0);
        ListNode result = res;

        while (left != null && right != null) {

            if (left.val < right.val) {
                result.next = new ListNode(left.val);
                result = result.next;
                left = left.next;
            } else {
                result.next = new ListNode(right.val);
                result = result.next;
                right = right.next;
            }
        }
        result.next = left != null ? left : right;
        return res.next;
    }


    public static void main(String[] args) {

        ListNode node = new ListNode(4);
        ListNode n = node;

        node.next = new ListNode(2);
        node = node.next;

        node.next = new ListNode(1);
        node = node.next;

        node.next = new ListNode(3);
        node = node.next;

        node.next = new ListNode(0);
        node = node.next;

        Sort_List_148 method = new Sort_List_148();
        ListNode res = method.sortList2(n);
        System.out.println(res);
    }
}
