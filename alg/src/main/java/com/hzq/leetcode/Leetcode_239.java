package com.hzq.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length < 1 || k <= 1)
        {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int length = nums.length;
        int[] res = new int[length - k + 1];

        int index = 0;
        for(int i = 0; i < length;i++)
        {
            //R 往右扩
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i])
            {
                queue.pollLast();
            }
            queue.addLast(i);

            //L往右扩

            if(queue.peekFirst() == i - k)
            {
                queue.pollFirst();
            }

            //填充Res

            if(i >= k - 1)
            {
                res[index++] = queue.peekFirst();
            }
        }
        return res;
    }
}
