package com.hzq.linkedlist;

import java.util.Stack;

/**
 * 判断是否是回文链表
 */
public class PalindromicLinkedList {

    private static class Node
    {
        int value;
        Node next;
        public Node(){}
    }

    /**
     * 利用栈结构，找出链表的中点，后半部分进栈，然后依次出栈与前半部分比较
     * @param head
     * @return
     */
    public static boolean isPalindromicLinkedList(Node head)
    {
        if(head == null || head.next == null)
        {
            return false;
        }
        Stack<Node> stack = new Stack<Node>();

        //寻找链表中点
         Node midNode = searchMidOfList(head);

         while(midNode.next!= null)
         {
             stack.push(midNode.next);
             midNode = midNode.next;
         }
         Node next = head;
         Node node = null;
         while(!stack.isEmpty())
         {
             if(next.value != stack.pop().value)
             {
                 return false;
             }
             next = next.next;
         }
         return true;
    }

    /**
     * 空间复杂度为O(1)的方式
     * @param head
     * @return
     */
    public static boolean isPalindromicLinkedList1(Node head)
    {
        if(head == null)
        {
            return false;
        }

        //首先还是找到链表中点
        Node midOfList = searchMidOfList(head);
        //然后将中点之后的链表翻转

        Node pre = null;
        Node next = null;

        while(midOfList != null)
        {
            next = midOfList.next;

            midOfList.next = pre;
            pre = midOfList;
            midOfList = next;
        }
        //用于恢复原链表
        Node flag = pre;
        //两个链表依次对比
        boolean res = true;
        while(head != null && pre != null)
        {
            if(head.value!= pre.value)
            {
                res = false;
                break;
            }
            head = head.next;
            pre = pre.next;
        }
        //恢复原链表

        Node pre1 = null;
        Node next1 = null;

        while(flag != null)
        {
            next1 = flag.next;

            flag.next = pre;
            pre = flag;
            flag = next1;
        }
        return res;
    }

    private static Node searchMidOfList(Node head) {

        if(head == null ||head.next==null || head.next.next == null)
        {
            return head;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
