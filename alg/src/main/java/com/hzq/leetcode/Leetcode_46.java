package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Leetcode_46 {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 1) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        process(nums, 0, res);
        return res;

    }

    private static void process(int[] nums, int index, List<List<Integer>> res) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int a : nums) {
                list.add(a);
            }
            res.add(list);
            return;

        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, 0, index);
            process(nums, index + 1, res);
            swap(nums, 0, index);
        }
    }

    private static void swap(int[] nums, int i, int index) {

        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
