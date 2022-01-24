package com.hzq.leetcode;

import java.util.LinkedList;

/**
 * 程序员代码面试指南第二版  10.最大值减去最小值小于或等于num的子数组数量
 */
public class Leetcode_239_1 {

    public static int getRes(int[] nums, int target)
    {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        //维护两个双端队列，存放子数组的最大最小值
        LinkedList<Integer> minQueue = new LinkedList<>();
        LinkedList<Integer> maxQueue = new LinkedList<>();

        int left = 0;
        int right = 0;
        int res = 0;
        //外层循环控制每个L计算出来的符合要求的子数组个数
        while(left < nums.length)
        {

            //right向右扩充
            while(right < nums.length)
            {
                while(!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[right])
                {
                    maxQueue.pollLast();
                }
                maxQueue.addLast(right);

                while(!minQueue.isEmpty() &&nums[minQueue.peekLast()] >= nums[right])
                {
                    minQueue.pollLast();
                }
                minQueue.addLast(right);

                if(maxQueue.peekFirst() - minQueue.peekFirst() > target)
                {
                    break;
                }
                right++;
            }
            //跳出循环说明此时right为第一个不符合要求的元素

            res+=right-left;

            if(minQueue.peekFirst() == left)
            {
                minQueue.pollFirst();
            }
            if(maxQueue.peekFirst() == left)
            {
                maxQueue.pollFirst();
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getRes(new int[]{1,2,3,4,5},2));
    }
}
