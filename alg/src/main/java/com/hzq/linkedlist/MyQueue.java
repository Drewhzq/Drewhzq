package com.hzq.linkedlist;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 数组实现定长队列
 * 先进先出
 */
public class MyQueue<T extends Object> {

    //内部存放元素的数组
    private Object[] queue;

    //push指针
    private int pushIndex;

    //poll指针
    private int pollIndex;

    //队列中元素个数
    private int size;

    //队列最大容量
    private int limit;

    private Object mutex = new Object();
    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public MyQueue(int cap) {
        this.limit = cap;
        this.pushIndex = 0;
        this.pollIndex = 0;
        this.size = 0;
    }

    /**
     * 向队列添加元素
     */
    public void add(T t) throws InterruptedException {

        lock.lock();
        try
        {
            if (queue == null) {
                this.queue = new Object[limit];
            } else {

                while (this.size == limit) {

                    System.out.println("队列满了，等待队列不满再加");
                    condition.await();
                }
            }
            queue[pushIndex] = t;
            updatePushIndex();
            size++;
            condition.signal();
        }finally {

            lock.unlock();
        }



    }

    /**
     * 队列中取元素
     */
    public T get() throws InterruptedException {
        lock.lock();
        try {
            while (queue == null || this.size == 0) {

                System.out.println("队列是空的，等有东西再取");

                condition.await();
            }
            T t = (T) queue[pollIndex];
            updatePollIndex();
            size--;
            condition.signal();
            return t;
        }finally {
            lock.unlock();
        }

    }

    private void updatePollIndex() {
        if (pollIndex == limit - 1) {
            pollIndex = 0;
        } else {
            pollIndex++;
        }
    }

    private void updatePushIndex() {
        if (pushIndex == limit - 1) {
            pushIndex = 0;
        } else {
            pushIndex++;
        }
    }

    public static void main(String[] args) throws InterruptedException {



        final MyQueue<Integer> myQueue = new MyQueue<>(4);

        new Thread(() ->
        {
            for(int i = 0 ; i < 10 ;i++)
            {
                try {
                    myQueue.add(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();

        TimeUnit.SECONDS.sleep(10);

        new Thread(() ->
        {
            for(int i = 0 ; i < 2 ;i++)
            {
                try {
                    myQueue.get();
                    TimeUnit.SECONDS.sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ).start();
    }
}
