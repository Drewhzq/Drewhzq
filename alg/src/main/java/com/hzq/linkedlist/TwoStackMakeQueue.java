package com.hzq.linkedlist;

import java.util.Stack;

public class TwoStackMakeQueue<T> {

    private Stack<T> pushStack;

    private Stack<T> popStack;

    public TwoStackMakeQueue()
    {
        pushStack = new Stack();
        popStack = new Stack();
    }

    public void push (T t)
    {

        pushStack.push(t);
        if(popStack.empty())
        {
            pushToPop();
        }
    }

    private void pushToPop()
    {
        while(!pushStack.empty())
        {
            popStack.add(pushStack.pop());
        }
    }

    public T poll()
    {
        if(popStack.empty())
        {
            pushToPop();
        }
        final T pop = popStack.pop();
        return pop;
    }

    public static void main(String[] args) {
        final TwoStackMakeQueue<Integer> queue = new TwoStackMakeQueue<>();
        queue.push(1);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        final Integer poll1 = queue.poll();
        System.out.println(poll1);
        final Integer poll2 = queue.poll();
        System.out.println(poll2);
        final Integer poll3 = queue.poll();
        System.out.println(poll3);
        final Integer poll4 = queue.poll();
        System.out.println(poll4);


    }
}
