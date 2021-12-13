package com.hzq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 */
public class Leetcode_1 {

    /**
     * O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i<nums.length;i++)
        {
            for(int j = i+1; j<nums.length;j++)
            {
                if(nums[i] +nums[j] == target)
                {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 时间复杂度小于 O(n2) 利用hash表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target)
    {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<nums.length;i++)
       {
           if(map.containsKey(target-nums[i]))
           {
               return new int[]{map.get(target-nums[i]), i};
           }
           map.put(nums[i],i);
       }
       return null;
    }
}
