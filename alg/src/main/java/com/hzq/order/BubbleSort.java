package com.hzq.order;

import java.util.Arrays;

/**
 * 冒泡排序
 * 0-1比较
 * 1-2比较
 * n-1 n比较
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arrays)
    {
        if(arrays == null)
        {
            throw new RuntimeException("arrays is null");
        }
        if(arrays.length == 1 || arrays.length == 2)
        {
            return arrays;
        }
        // 2,5,1,6,4,9,15
        for(int i = arrays.length; i > 0; i--)
        {
            for(int j = 0; j < i - 1; j++)
            {
                if(arrays[j+1] < arrays[j])
                {
                    swap(arrays,j,j+1);

                }
            }
        }
        return arrays;
    }
    private static void swap(int[] arrays, int i, int j)
    {
        if(arrays == null)
        {
            throw new RuntimeException("arrays is null");
        }
        int tmp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = tmp;

    }

    public static void main(String[] args) {
        int [] arrays = new int[]{2,5,1,6,4,9,15};
        final int[] ints = bubbleSort(arrays);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
