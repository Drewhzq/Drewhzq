package com.hzq;

import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    /**
     * @param arr
     * @param target
     * @return
     */
    public static List<List<Integer>> twoNumsCount(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return res;
        }

        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (arr[left] + arr[right] > target) {
                right--;
            } else if (arr[left] + arr[right] < target) {
                left++;
            } else {

                if (left == 0 || arr[left - 1] != arr[left]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[left]);
                    list.add(arr[right]);
                    res.add(list);
                }
                left++;
            }
        }
        return res;
    }


    public static int[] nextGreaterElement(int[] nums)
    {

        if(nums == null || nums.length == 0 || nums.length == 1)
        {
            return nums;
        }
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++)
        {
            for(int j = i; j < nums.length;j++)
            {
                if(nums[i] < nums[j])
                {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        final List<List<Integer>> lists = twoNumsCount(new int[]{-1, 0, -1, 2, 3, 4,-1,1}, 3);
        System.out.println(lists);
        Arrays.stream(nextGreaterElement(new int[]{10,7,36,30,22,25,13,29,40,5})).forEach(System.out::println);
    }
}
