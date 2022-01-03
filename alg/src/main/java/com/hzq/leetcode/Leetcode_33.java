package com.hzq.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_33 {
    public static int search(int[] nums, int target) {


        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        //外层循环，当left == right 时若还没搜索到，返回-1
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            //如果nums[left] == nums[mid] == nums[right]
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                while (left != mid && nums[left] == nums[mid]) {
                    left++;
                }
                //若跳出上层循环是因为left != right 则continue，以mid+1为left继续最外层循环
                if (left == mid) {
                    left = mid + 1;
                    continue;
                }
            }

            //执行到该步骤，说明 nums[left] != nums[mid]
            if (nums[left] != nums[mid]) {

                //若左大于mid，则说明mid-右是有序的
                if (nums[left] > nums[mid]) {
                    //判断target是否在右边有序部分
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }

                } else {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }

                }
                //若nums[left] == nums[mid]，则有nums[right] != nums[mid],同理
            } else {
                if (nums[right] > nums[mid]) {

                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if (target >= nums[left] && target < nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        search(new int[]{1, 3}, 0);
    }
}
