package com.hzq;

import java.util.Arrays;

public class Test {


    public static int[] nextGreaterElement(int[] nums)
    {
        if(nums == null || nums.length == 1)
        {
            return new int[]{0};
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            int cur = nums[i];
            int max = 0;
            for(int j = i+1; j < nums.length;j++)
            {
                 if(nums[j] > cur)
                 {
                     max = nums[j];
                     break;
                 }
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10,7,36,30,22,25,13,29,40,5};
        final int[] nextGreaterElement = nextGreaterElement(arr);
        Arrays.stream(nextGreaterElement).forEach(System.out::println);
    }
}
