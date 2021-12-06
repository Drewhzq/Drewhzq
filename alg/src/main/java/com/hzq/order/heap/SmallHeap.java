package com.hzq.order.heap;

public class SmallHeap {

    private int[] array;

    private int limit;

    private int  heapSize;

    public SmallHeap(int cap)
    {
        this.array = new int[cap];
        this.limit = cap;
        this.heapSize = 0;
    }

    /**
     * push
     */
    public void push(int num)
    {
        if(limit == heapSize)
        {
            throw  new RuntimeException("heap is full");
        }

        array[heapSize] = num;
        heapInsert(array, heapSize++);
    }

    /**
     * poll
     * @return
     */
    public int poll()
    {
        if(isEmpty())
        {
            throw new RuntimeException("the heap is null");
        }
        int res = array[0];
        swap(array, 0, --heapSize);
        heapIfy(array, 0, heapSize);

        return res;

    }

    /**
     * heapIfy
     * @param array
     * @param index
     * @param heapSize
     */
    private void heapIfy(int[] array, int index, int heapSize)
    {
        int left = index * 2 + 1;
        while(left < heapSize)
        {
            int smallest = left + 1 < heapSize && array[left] > array[left+1] ? left+1 : left;
            int smallIndex = array[smallest] > array[index] ? index : smallest;
            if(smallIndex == index)
            {
                break;
            }
            swap(array,smallIndex, index);
            index = smallIndex;
            left = 2 * index +1;

        }

    }

    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    /**
     * heapInsert
     * @param array
     * @param i
     */
    private void heapInsert(int[] array, int i)
    {
        while(array[i] < array[(i-1) /2])
        {
            swap(array, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    private void swap(int[] array, int i, int i1)
    {
        int tmp = array[i];
        array[i]  = array[i1];
        array[i1] = tmp;
    }

    public static void main(String[] args) {

        final SmallHeap smallHeap = new SmallHeap(6);
        smallHeap.push(6);
        smallHeap.push(1);
        smallHeap.push(9);
        smallHeap.push(8);
        smallHeap.push(4);
        smallHeap.push(7);
        while(!smallHeap.isEmpty())
        {
            System.out.println(smallHeap.poll());
        }

    }
}
