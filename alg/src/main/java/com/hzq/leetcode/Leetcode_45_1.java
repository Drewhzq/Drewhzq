package com.hzq.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *给定一个非负整数数组 nums ，和起始位置start,终止位置end 。
 *  *
 *  * 数组中的每个元素代表你在该位置可以向左向右跳跃的固定长度。
 *  *
 *  * 判断 start-> end的跳跃的最少次数
 */
public class Leetcode_45_1 {

    /**
     * 宽度优先遍历
     * @param nums
     * @param start
     * @param end
     * @return
     */
    public static int jump(int[] nums,int start, int end)
    {
        if(nums == null || nums.length < 1)
        {
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer,Integer> levelMap = new HashMap<>();
        queue.add(nums[start-1]);
        levelMap.put(start-1,0);
        while(!queue.isEmpty())
        {
            final Integer poll = queue.poll();
            if(poll == end)
            {
                return levelMap.get(poll);
            }

            if(start-1+nums[start-1] < nums.length && !levelMap.containsKey(start-1+nums[start-1]))
            {
                queue.add(start+nums[start-1]);
                levelMap.put( start+nums[start-1],levelMap.get(start-1)+1);
            }
            if(start-1-nums[start-1] >=0 && !levelMap.containsKey(start-1-nums[start-1]))
            {
                queue.add(start-nums[start-1]);
                levelMap.put(start-nums[start-1],levelMap.get(start-1)+1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        final int jump = jump(new int[]{1, 2, 3, 4, 5, 6}, 3, 6);
        System.out.println(jump);
    }
}
