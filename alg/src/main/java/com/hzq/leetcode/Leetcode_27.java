package com.hzq.leetcode;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_27 {

    public static int removeElement(int[] nums, int val) {

        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            if (nums[start] == val) {
                swap(nums, start, end--);
            } else {
                start++;
            }
        }
        return start;
    }

    private static void swap(int[] nums, int start, int i) {

        int tmp = nums[start];
        nums[start] = nums[i];
        nums[i] = tmp;

    }

    public static void main(String[] args) {
        removeElement(new int[]{3,2,2,3},3);
    }
}
