package com.hzq.order.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 已知一个几乎有序的数组，如果排好序，每个元素的移动距离不超过k，并且k相对于数组长度是比较小的。
 * 选择一种合适的算法
 */
public class AlmostOrderArrays {

   public static int[] sort(int[] arr, int k)
   {
       final PriorityQueue<Integer> queue = new PriorityQueue<>();

       int i = 0;
       for(; i < Math.min(arr.length-1, k); i++)
       {
           queue.add(arr[i]);
       }

       int index = 0;
       for(;i < arr.length; i++)
       {
            queue.add(arr[i]);
            arr[index++] = queue.poll();
       }
       while(!queue.isEmpty())
       {
           arr[index++] = queue.poll();
       }
       return arr;
   }

    public static void main(String[] args) {
       int[] arr = new int[]{1,3,4,5,6,9,8,10,9,11,14};
        final int[] sort = sort(arr,2 );
        Arrays.stream(sort).forEach(System.out::println);

    }
}
