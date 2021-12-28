package com.hzq.leetcode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class Leetcode_24 {

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

    public static ListNode swapPairs(ListNode head) {

        if(head == null ||head.next == null)
        {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        process(cur);

        return newHead.next;
    }

    private static void process(ListNode cur)
    {

        if(cur == null || cur.next == null || cur.next.next == null)
        {
            return;
        }

        ListNode third = cur.next.next;
        ListNode second = cur.next;
        cur.next = third;
        cur = third;
        second.next = third.next;
        third.next = second;
        process(cur);

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs(node1);
    }
}
