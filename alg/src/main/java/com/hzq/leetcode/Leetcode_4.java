package com.hzq.leetcode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }


    /**
     * 给定两个有序数组，数组1在l1-r1,数组2在l2-r2区间等长，合并它们，返回合并后的中位数
     * a1 a2 a3 a4
     * b1 b2 b3 b4
     *
     * @return
     */
    public static double getRes(int[] arr1, int[] arr2) {
        int length = arr1.length + arr2.length;
        if (arr1.length != 0 && arr2.length != 0) {
            if ((length & 1) == 1) {
                return getTwoArrayK(arr1, arr2, length / 2 + 1);
            } else {
                final double twoArrayK1 = getTwoArrayK(arr1, arr2, (length / 2));
                final double twoArrayK2 = getTwoArrayK(arr1, arr2, (length / 2)+1);

                return (double) (twoArrayK1 + twoArrayK2) / 2;
            }
        } else if (arr1.length == 0) {
            return  (length & 1) == 1 ? (double)arr2[arr2.length / 2] : (double)(arr2[arr2.length / 2] + arr2[arr2.length / 2 - 1]) / 2;
        } else if (arr2.length == 0) {
            return  (length & 1) == 1 ? (double)arr1[arr1.length / 2] : (double)(arr1[arr1.length / 2] + arr1[arr1.length / 2 - 1]) / 2;
        } else {
            return 0;
        }

    }


    public static int getTwoArrayK(int[] arr1, int[] arr2, int k) {
        int[] shortArr = arr1.length > arr2.length ? arr2 : arr1;
        int[] longArr = arr1.length > arr2.length ? arr1 : arr2;

        if (k <= shortArr.length) {
            return getUpMedian(arr1, 0, k-1, arr2, 0, k-1);
        } else if (k > shortArr.length && k <= longArr.length) {
            if (longArr[k - shortArr.length - 1] > shortArr[shortArr.length - 1]) {
                return longArr[k - shortArr.length - 1];
            } else {
                return getUpMedian(shortArr, 0, shortArr.length - 1, longArr, k - shortArr.length, k-1);
            }

        } else {
            if (longArr[k - shortArr.length - 1] > shortArr[shortArr.length - 1]) {
                return longArr[k - shortArr.length - 1];
            }
            if (shortArr[k - longArr.length - 1] > longArr[longArr.length - 1]) {
                return shortArr[k - longArr.length - 1];
            }
            return getUpMedian(shortArr, k - longArr.length, shortArr.length - 1, longArr, k - shortArr.length,
                    longArr.length - 1);
        }
    }


    public static int getUpMedian(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2) {

        if (l1 >= r1) {
            return Math.min(arr1[r1], arr2[r2]);
        }
        int median1 = l1 + (r1 - l1) / 2;
        int median2 = l2 + (r2 - l2) / 2;
        if (arr1[median1] == arr2[median2]) {
            return arr1[median1];
        }
        boolean flag = ((r1 - l1 + 1) & 1) == 1;
        //奇数
        if (flag) {
            if (arr1[median1] > arr2[median2]) {
                if (arr2[median2] > arr1[median1 - 1]) {
                    return arr2[median2];
                } else {
                    return getUpMedian(arr1, l1, median1 - 1, arr2, median2 + 1, r2);
                }
            } else {
                if (arr1[median1] > arr2[median2 - 1]) {
                    return arr1[median1];
                } else {
                    return getUpMedian(arr1, median1 + 1, r1, arr2, l2, median2 - 1);
                }
            }
        }
        //偶数
        else {
            if (arr1[median1] > arr2[median2]) {
                return getUpMedian(arr1, l1, median1, arr2, median2 + 1, r2);
            } else {
                return getUpMedian(arr1, median1 + 1, r1, arr2, l2, median2);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{1};
        // final int upMedian = getUpMedian(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);

        //System.out.println(upMedian);
        System.out.println(getRes(arr1, arr2));
    }
}
