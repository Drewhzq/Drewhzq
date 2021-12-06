package com.hzq.order;

import java.util.Arrays;

/**
 * 插入排序
 * 0-1之前有序
 * 0-2之间有序
 * ...
 * n-1 - n之间有序
 */
public class InsertionSort {

    public static int[] insertSort(int[] arrays)
    {
        if(arrays == null)
        {
            throw new RuntimeException("arrays is null");
        }
        if(arrays.length == 1 || arrays.length == 2)
        {
            return arrays;
        }
        for(int i = 0; i < arrays.length - 1; i++)
        {
            for(int j = i + 1 ; j > 0 && arrays[j] > arrays[j-1]; j--)
            {
                swap(arrays,j,j-1);
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
        final int[] ints = insertSort(arrays);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
