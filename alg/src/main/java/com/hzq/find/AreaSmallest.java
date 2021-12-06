package com.hzq.find;

/**
 * 是否存在局部最小问题
 */
public class AreaSmallest {

    public static int isExistAreaSmallest(int[] arrays) {
        if (arrays == null) {
            throw new RuntimeException("arrays is null");
        }
        if (arrays.length == 1 || arrays[0] < arrays[1]) {
            return arrays[0];
        }
        if (arrays[arrays.length - 1] < arrays[arrays.length - 2]) {
            return arrays[arrays.length - 1];
        }

        int left = 1;
        int right = arrays.length - 2;
        int mid1 = 0;
        int mid2 = 0;

        while (left < right) {
            mid1 = left+((right-left) >> 1);
            System.out.println("mid1=="+mid1);
            System.out.println("mid2=="+mid2);
            if (arrays[mid1] > arrays[mid1 - 1]) {
                right = mid1 - 1;
            } else if (arrays[mid1] > arrays[mid1 + 1]) {
                left = mid1 + 1;
            } else {
                return mid1;
            }

        }
        return right;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{7, 6, 4, 3, 2, 5, 6, 7, 8, 9, 10};
        final int i = isExistAreaSmallest(arrays);
        System.out.println(i);
    }
}
