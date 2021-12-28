package com.hzq.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class Leetcode_23 {

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

    static class ListNodeComparator implements Comparator<ListNode>
    {

        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
        for(ListNode listNode : lists)
        {
            if(listNode != null)
            {
                queue.add(listNode);
            }
        }

        if(queue.isEmpty())
        {
            return null;
        }
        ListNode head = queue.poll();

        ListNode cur = head;

        if(head.next != null)
        {
            queue.add(head.next);
        }

        while(!queue.isEmpty())
        {
            final ListNode poll = queue.poll();
            cur.next = poll;
            if(poll.next != null)
            {
                queue.add(cur.next);
            }
            cur = cur.next;
        }
        return head;

    }
}
