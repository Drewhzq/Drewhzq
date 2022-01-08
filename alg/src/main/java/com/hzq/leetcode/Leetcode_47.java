package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Leetcode_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1)
        {
            return res;
        }

        process(nums, 0, res);
        return res;
    }

    private void process(int[] nums, int index, List<List<Integer>> res) {

        if(index == nums.length)
        {
            List<Integer> list = new ArrayList<>();
            for(int a:nums)
            {
                list.add(a);
            }
            res.add(list);
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = index; i<nums.length;i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
                swap(nums,i,index);
                process(nums,index+1,res);
                swap(nums,i,index);
            }

        }
    }

    private static void swap(int[] nums, int i, int index) {

        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
