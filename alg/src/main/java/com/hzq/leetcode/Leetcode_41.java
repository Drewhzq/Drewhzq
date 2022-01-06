package com.hzq.leetcode;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
public class Leetcode_41 {

    /**
     * 双指针法
     * 期望数组各个元素都满足 index+1 = nums[index]
     *
     * @param nums
     * @return
     */
    public static int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length;

        while (left < right) {
            //1、场景一 nums[left] == left+1,符合条件 left++
            if (left + 1 == nums[left]) {
                left++;
            //2、场景二 当nums[left] > right 说明存在一个比right大的树，预期的1-n的数组 变为1 - n-1
                // 场景三 当 nums[left] < left + 1，说明有比left+1还小的数，预期的1-n的数组 变为 1 - n-1
                //场景四 nums[left] == nums[nums[left] - 1] 无需交换，有相同的数，预期的1-n的数组，变为 1 - n-1
            } else if (nums[left] > right || nums[left] < left + 1 || nums[left] == nums[nums[left] - 1]) {
                swap(nums, left, --right);

                //场景五，left和 nums[nums[left] - 1]交换位置
            } else {

                swap(nums,left,nums[left] - 1);
            }
        }
        return left + 1;

    }

    private static void swap(int[] nums, int left, int i) {

        int tmp = nums[left];
        nums[left] = nums[i];
        nums[i] = tmp;
    }
}
