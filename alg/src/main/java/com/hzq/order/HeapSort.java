package com.hzq.order;

import java.util.Arrays;

public class HeapSort {


    public static void main(String[] args) {
          int[] arr= new int[]{4,6,1,7,4,8,9,5,9,2,6};
        final int[] ints = heapSort(arr);
        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * 堆排序
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr)
    {
        //使数组变为大顶堆
//        for(int i = 0; i < arr.length; i++)
//        {
//            heapInsert(arr, i);
//        }
        //使数组变成大顶堆优化
        for(int i = arr.length-1; i>=0; i--)
        {
            heapIfy(arr, i, arr.length);
        }
        //将根节点移到数组末尾
        int length = arr.length;
        swap(arr, 0, --length);

        while(length > 0)
        {
            heapIfy(arr,0, length);
            swap(arr, 0, --length);
        }

        return arr;
    }

    private static void heapIfy(int[] arr, int index, int length)
    {
        int left = index*2 +1;
        while(left < length)
        {
            int largest = left+1 < length && arr[left+1] > arr[left] ? left+1:left;
            int largestIndex = arr[index] > arr[largest] ? index:largest;
            if(largestIndex == index)
            {
                break;
            }
            swap(arr,largestIndex,index);
            index = largestIndex;
            left = index*2 +1;
        }

    }

    private static void heapInsert(int[] arr, int i)
    {
        while(arr[i] > arr[(i-1)/2])
        {
            swap(arr, i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    private static void swap(int[] arr, int i, int i1)
    {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
