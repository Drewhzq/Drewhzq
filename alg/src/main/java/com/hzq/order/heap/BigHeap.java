package com.hzq.order.heap;

public class BigHeap {

    private int[] arrays;

    private int limit;

    private int heapSize;


    public BigHeap(int cap)
    {
        this.arrays = new int[cap];
        this.limit = cap;
        this.heapSize = 0;
    }

    /**
     * push方法
     */
    public void push(int num)
    {
        if(heapSize == limit)
        {
            throw new RuntimeException("the heap is full");
        }
        arrays[heapSize] = num;
        heapInsert(arrays, heapSize++);
    }

    public boolean isEmpty()
    {
        return heapSize == 0;
    }

    /**
     * poll
     */
    public int poll()
    {
        if(heapSize == 0)
        {
            throw new RuntimeException("the heap is null");
        }
        int res = arrays[0];
        swap(arrays, --heapSize, 0);
        heapIfy(arrays, 0, heapSize);
        return res;

    }

    /**
     * heapIfy
     * @param arrays
     * @param
     * @param
     */
    private void heapIfy(int[] arrays, int index, int heapSize)
    {
        int left = index * 2 + 1;
        while(left < heapSize)
        {
            int largest = left + 1 < heapSize && arrays[left] < arrays[left + 1] ? left+1 : left;

            int largestIndex = arrays[index] > arrays[largest] ?  index : largest;

            if(largestIndex == index)
            {
                break;
            }
            swap(arrays, largestIndex, index);
            index = largestIndex;
            left = index * 2 + 1;
        }
    }

    /**
     * heapInsert
     * @param arrays
     * @param i
     */
    private void heapInsert(int[] arrays, int i)
    {
        while (arrays[i] > arrays[(i - 1) / 2])
        {
            swap(arrays, i, (i - 1) / 2);
            i = (i -1) /2;
        }
    }

    private void swap(int[] arrays, int heapSize, int i)
    {
        int tmp = arrays[heapSize];
        arrays[heapSize] = arrays[i];
        arrays[i] = tmp;
    }


    public static void main(String[] args) {
        final BigHeap bigHeap = new BigHeap(6);
        bigHeap.push(5);
        bigHeap.push(7);
        bigHeap.push(8);
        bigHeap.push(2);
        bigHeap.push(4);
        while (!bigHeap.isEmpty())
        {
            System.out.println(bigHeap.poll());
        }
    }
}
