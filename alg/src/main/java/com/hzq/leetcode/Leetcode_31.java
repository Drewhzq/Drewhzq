package com.hzq.leetcode;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列（即，组合出下一个更大的整数）。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_31 {

    public static void nextPermutation(int[] nums) {

        int tmp = 0;
        boolean flag = false;
        for(int i = nums.length - 1; i>0; i--)
        {
            if(nums[i] > nums[i-1])
            {
                tmp = i - 1;
                flag =true;
                break;
            }
        }
        if(!flag)
        {
            reverseArray(nums,0, nums.length - 1);
            return;
        }

        for(int i = nums.length-1; i >tmp; i--)
        {
            if(nums[tmp] < nums[i])
            {
                swap(nums,tmp,i);
                break;
            }
        }
        reverseArray(nums, tmp + 1,nums.length - 1);

    }

    private static void reverseArray(int[] nums,int left, int right) {

        while(left <= right)
        {
            swap(nums,left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int i, int i1) {
        int tmp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = tmp;
    }
}
