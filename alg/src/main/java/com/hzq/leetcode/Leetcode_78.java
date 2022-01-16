package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_78 {

    public static List<List<Integer>> subsets(int[] nums) {

        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(0,nums,list,res);
        return res;

    }

    private static List<List<Integer>> process(int index, int[] nums, List<Integer> list, List<List<Integer>> res) {

        if(index <= nums.length)
        {
            res.add(new ArrayList<>(list));
        }

        for(int i = index; i < nums.length;i++)
        {
            list.add(nums[i]);
            process(i+1,nums,list,res);
            list.remove(list.size()-1);
        }
        return res;

    }

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});
    }
}
