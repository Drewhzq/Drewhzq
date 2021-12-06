package com.hzq.linkedlist;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 两个队列实现栈
 * @param <T>
 */
public class TwoQueueMakeStack<T> {

    private Queue<T> queuedata;

    private Queue<T> queuehelp;

    public TwoQueueMakeStack()
    {
        queuedata = new ArrayDeque();
        queuehelp= new ArrayDeque<>();
    }

    public void add(T t)
    {
        queuedata.add(t);
    }

    public T take()
    {
        T t;
        while((t = queuedata.poll()) != null)
        {
            queuehelp.add(t);
            if(queuedata.size() == 1)
            {
                break;
            }
        }
        T res = queuedata.poll();
        queuedata = queuehelp;
        queuehelp = new ArrayDeque<>();
        return res;

    }

    public static void main(String[] args) {

        final TwoQueueMakeStack<Integer> stack = new TwoQueueMakeStack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        Integer i;
        while((i=stack.take())!=null)
        {
            System.out.println(i);
        }
    }
}
