package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_77 {

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if(k > n)
        {
            return res;
        }
        int[] nums = new int[n];
        for(int i = 0;i < nums.length;i++)
        {
            nums[i] = i+1;
        }
        List<Integer> list = new ArrayList<>();
        return process(0,k,nums,list,res);

    }

    private static List<List<Integer>> process(int index,int k, int[] nums, List<Integer> list, List<List<Integer>> res) {

        if(list.size() == k)
        {
            res.add(new ArrayList<>(list));
            return res;
        }

        for(int i = index; i < nums.length - ( k - list.size()) + 1;i++)
        {
            list.add(nums[i]);
            process(i+1,k,nums,list,res);
            list.remove(list.size()-1);
        }
        return res;
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
