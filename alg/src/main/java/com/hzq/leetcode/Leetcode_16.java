package com.hzq.leetcode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_16 {

    public static int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            throw new RuntimeException("nums is null");
        }

        int closest = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                if (Math.abs(target - (nums[i] + nums[left] + nums[right])) < Math.abs(closest - target)) {
                    closest = nums[i] + nums[left] + nums[right];
                }

                if (nums[left] + nums[right] < target - nums[i]) {
                    left++;
                } else if (nums[left] + nums[right] > target - nums[i]) {
                    right--;
                } else {
                    return closest;
                }
            }

        }
        return closest;

    }

    public static void main(String[] args) {
        threeSumClosest(new int[]{1,1,-1,-1,3},-1);
    }
}
