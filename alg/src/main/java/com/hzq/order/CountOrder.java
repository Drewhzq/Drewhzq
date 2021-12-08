package com.hzq.order;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountOrder {


    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,5,6,8,9,35,89,31,5,45};
        Arrays.stream(countSort(arr)).forEach(System.out::println);
    }
    /**
     * 计数排序，适用于数组中元素不多的情况
     * @param arr
     * @return
     */
    public static int[] countSort(int[] arr)
    {

        if(arr == null || arr.length == 1)
        {
            return arr;
        }
        int[] nums = new int[200];

        for(int i = 0; i< arr.length;i++)
        {
            nums[arr[i]] ++;
        }

        int index = 0;
        for(int i = 0; i< nums.length;i++)
        {
            while(nums[i]-->0)
            {
                arr[index++] = i;
            }
        }
        return arr;
    }
}
