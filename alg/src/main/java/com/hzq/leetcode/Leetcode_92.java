package com.hzq.leetcode;

import java.util.List;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_92 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = new ListNode(0,head);
        ListNode cur = tmp.next;

        ListNode lastNode = null;
        for(int i = 1;i < left;i++)
        {
            lastNode = cur;
            cur = cur.next;
        }
        ListNode newHead = null;

        ListNode next = null;
        ListNode tailNode = null;
        ListNode perNode = null;
        perNode = lastNode.next;
        while(left <= right)
        {
            if(left == right)
            {
                tailNode = cur.next;
            }
            next = cur.next;
            lastNode.next = cur;
            cur.next = newHead;
            newHead = cur;
            cur = next;
            left++;

        }
        perNode.next = tailNode;
        return tmp.next;
    }
}
