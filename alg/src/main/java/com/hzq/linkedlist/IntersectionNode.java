package com.hzq.linkedlist;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class IntersectionNode {

    private static class Node
    {
        int value;
        Node next;
        public Node(){}
    }

    /**
     * 判断两个链表是否相交，并返回第一个相交的Node
     * @param node1
     * @return
     */
    public static Node getSectionNode(Node node1, Node node2)
    {
        if(node1 == null || node2 == null)
        {
            return null;
        }
        final Node loopNode1 = getLoopNode1(node1);
        final Node loopNode2 = getLoopNode1(node2);
        if(loopNode1 == null && loopNode2 == null)
        {
            return getNoLoopSectionNode(node1,node2);
        }else if(loopNode1!=null && loopNode2!=null)
        {
            return getAllLoopSectionNode(node1, node2,loopNode1,loopNode2);
        }
        return null;
    }
    
    /**
     * 无环链表第一个相交的节点
     * @param head
     * @return
     */
    public static Node getNoLoopSectionNode(Node head1, Node head2)
    {
        if(head1 == null || head2 ==null)
        {
            return null;
        }
        //记录两个链表的长度差值
        int count = 0;
        Node cur1 = head1;
        Node cur2 = head2;

        while(cur1.next != null)
        {
            count++;
            cur1 = cur1.next;
        }

        while(cur2.next != null)
        {
            count--;
            cur2 = cur2.next;
        }
        //如果两个链接的尾节点都不相等，则肯定不相交
        if(cur1 != cur2)
        {
            return null;
        }

        cur1 = count > 0 ? head1 : head2;
        cur2 = count > 0 ? head2 : head1;
        count = Math.abs(count);
        while (count != 0)
        {
            cur1 = cur1.next;
            count--;
        }

        while(cur1 != cur2)
        {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 有环链表的相交节点
     * 一个有环、一个无环不可能相交
     * 所以只考虑两个都有环的情况下是否相交
     * @param head1
     * @param head2
     * @param loop1
     * @param loop2
     * @return
     */
    public static Node getAllLoopSectionNode(Node head1, Node head2, Node loop1, Node loop2)
    {
        //当两个链表的入环节点相同时
        if(loop1 == loop2)
        {
            Node cur1 = head1;
            Node cur2 = head2;
            int count = 0;

            while(cur1 != loop1)
            {
                count++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2)
            {
                count--;
                cur2 =cur2.next;
            }
            cur1 = count > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            count = Math.abs(count);
            while(count != 0)
            {
                count--;
                cur1 = cur1.next;
            }
            while(cur1 != cur2)
            {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        //当两个链表的入环节点不是 同一个时
        Node loopNode = loop1.next;
        while(loopNode != loop1)
        {
            if(loopNode == loop2)
            {
                return loopNode;
            }
            loopNode = loopNode.next;
        }
        return null;
    }


    /**
     * 快慢指针
     * @param head
     * @return
     */
    public static Node getLoopNode1(Node head)
    {
        if(head == null || head.next == null || head.next.next == null)
        {
            return null;
        }
        //fast
        Node fast = head.next.next;
        //slow
        Node slow = head.next;

        while(fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //跳出循环代表有环，让fast重新指向head
        fast = head;

        while (fast != slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;

    }
}
