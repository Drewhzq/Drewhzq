package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_90 {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 1)
        {
            return res;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        return process(nums,0,list,res);
    }

    private static List<List<Integer>> process(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {

        if(index <= nums.length)
        {
            res.add(new ArrayList<>(list));
        }

        int tmp = 100;
        for(int i = index;i < nums.length;i++)
        {
            if(tmp == nums[i])
            {
                continue;
            }
            list.add(nums[i]);
            process(nums,i + 1, list,res);
            tmp = list.remove(list.size() - 1);
        }

        return res;
    }
}

