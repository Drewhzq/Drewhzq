package com.hzq.leetcode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *
 */
public class Leetcode_61 {

  private  static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode rotateRight(ListNode head, int k) {

      if(head == null || head.next == null || k == 0)
      {
          return head;
      }
      ListNode cur = head;
      int length = 0;
      while(cur != null)
      {
         cur = cur.next;
         length++;
      }
      cur.next = head;

      int times = 0;
      ListNode cur1 = head;
      while(times != length + k)
      {
          cur1 = cur1.next;
          times++;
      }
      ListNode res = cur1.next;
      cur1.next = null;
      return res;



    }
}
