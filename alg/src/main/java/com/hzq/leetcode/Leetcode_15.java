package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
        {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = nums.length - 1; i > 1;i--)
        {
            int last = nums[i];
            final List<List<Integer>> twoSum = twoSum(nums, i, -last);
            if(i == nums.length-1 || nums[i+1] != nums[i])
            {
                if(!twoSum.isEmpty())
                {
                    for(List<Integer> list : twoSum)
                    {
                        list.add(last);
                        res.add(list);
                    }
                }
            }

        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int left = 0;
        int right = end ;

        List<List<Integer>> res = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {

                if(right == end || nums[right+1] != nums[right])
                {
                    List<Integer> list = new ArrayList();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                }
                right--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});

    }
}
