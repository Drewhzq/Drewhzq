package com.hzq.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CopyListByRanom {

    private static class Node
    {
        int value;
        Node next;
        Node random;
        public Node(int value){
            this.value = value;
        }
    }

    /**
     * 利用hash表实现
     * @param head
     * @return
     */
    public static Node copyListRandom1(Node head)
    {
        if(head == null)
        {
            return null;
        }

        Map<Node, Node> nodeNodeHashMap = new HashMap<>();
        Node next = null;
        Node cur = head;
        while(cur != null)
        {
            next = cur.next;
            nodeNodeHashMap.put(cur, new Node(cur.value));
            cur = next;
        }
        cur = head;

        while(cur != null)
        {
            next = cur.next;
            nodeNodeHashMap.get(cur).next = nodeNodeHashMap.get(cur.next);
            nodeNodeHashMap.get(cur).random = nodeNodeHashMap.get(cur.random);
            cur = next;
        }
        return nodeNodeHashMap.get(head);
    }

    /**
     * 在原表上修改 空间复杂度O(1)
     * @param head
     * @return
     */
    public static Node copyListRandom2(Node head)
    {
        if(head == null)
        {
            return null;
        }
        //遍历链表，使得每一个节点的next指针指向它的克隆节点

        Node cur = head;
        Node next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }

        //再次遍历链表，设置克隆节点的random指针

        cur = head;
        while(cur != null)
        {
            next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        //还原链表并返回结果
        Node res = head.next;
        cur = head;
        while(cur != null)
        {
            next = cur.next.next;
            cur.next.next = next == null ? null :next.next;
            cur.next = next;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(6);
        Node node4 = new Node(3);
        Node node5 = new Node(5);
        Node node6 = new Node(3);
        Node node7 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        Node copy = copyListRandom2(node1);

        while(copy != null)
        {
            System.out.println(copy.value);
            copy = copy.next;
        }
    }

}
