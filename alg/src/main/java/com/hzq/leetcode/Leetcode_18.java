package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 */
public class Leetcode_18 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4)
        {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3;i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
            {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++)
            {

                if(j > i + 1 && nums[j] == nums[j-1])
                {
                    continue;
                }
                List<List<Integer>> list = towNumCount(nums,j+1,nums.length-1,target - nums[j] - nums[i]);

                for(List<Integer> li :list)
                {
                    li.add(0, nums[i]);
                    li.add(1,nums[j]);
                }
                res.addAll(list);
            }
        }
        return res;


    }

    public static List<List<Integer>> towNumCount(int[] nums, int left, int right, int target) {
        List<List<Integer>> list = new ArrayList<>();

        int L = left;
        int R = right;

        while (L < R) {
            if (nums[L] + nums[R] < target) {
                L++;
            } else if (nums[L] + nums[R] > target) {
                R--;
            } else {
                if(L == left || nums[L - 1] != nums[L])
                {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[L]);
                    tmp.add(nums[R]);
                    list.add(tmp);
                }
                L++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
    }
}
