package com.hzq.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_53 {

    public static int maxSubArray(int[] nums) {


        if(nums == null || nums.length < 1)
        {
            return 0;
        }
        int last = nums[0];
        int max = last;
        for(int i = 1; i<nums.length;i++)
        {
            int cur = Math.max(nums[i],last+nums[i]);
            last = cur;
            max = Math.max(max,cur);
        }
        return max;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
