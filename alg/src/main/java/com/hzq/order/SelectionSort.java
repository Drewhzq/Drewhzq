package com.hzq.order;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {



    public static int[] selectSort(int[] arrays)
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
        for(int i = 0; i < arrays.length; i++)
        {
            int maxIndex = i;
            for(int j = i + 1; j < arrays.length; j++)
            {
                //找出最大的
                maxIndex = arrays[j] > arrays[maxIndex] ? j : maxIndex;

            }
            System.out.println("==="+arrays[maxIndex]);
            //交换位置
            swap(arrays,i,maxIndex);
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
        final int[] ints = selectSort(arrays);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
