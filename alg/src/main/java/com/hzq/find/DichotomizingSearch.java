package com.hzq.find;

/**
 * 二分查找
 */
public class DichotomizingSearch {


    /**
     * 二分查找有序数组中指定数的索引
     * @param arrays
     * @return
     */
    public static int dichSearch(int[] arrays, int target)
    {
        if(arrays == null)
        {
            throw new RuntimeException("arrays is null");
        }
        if(arrays.length == 1 && arrays[0] != target)
        {
            return -1;
        }
        int left = 0;
        int right = arrays.length;

        while(left < right)
        {
            int mid = left + ((right-left) >> 2);
            if(arrays[mid] == target)
            {
                return mid;
            }
            if(target > mid)
            {
                left = mid + 1;
            }
            if(target < mid)
            {
                right = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{0,1,2,3,4,5,6,7,8,9};
        final int i = dichSearch(arrays, 8);
        System.out.println(i);
    }
}
