package com.hzq.order;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 8, 1, 2, 6, 7, 4, 5, 8, 6, 7};

        final int[] ints = quickSort3(arr1, 0, arr1.length - 1);

        Arrays.stream(ints).forEach(System.out::println);
    }

    /**
     * 快排1.0
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] quickSort1(int[] arr, int L, int R) {
        if (L >= R) {
            return arr;
        }
        int eqIndex = partition1(arr, L, R);
        quickSort1(arr, L, eqIndex);
        quickSort1(arr, eqIndex + 1, R);
        return arr;
    }

    /**
     * 快排2.0
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] quickSort2(int[] arr, int L, int R) {
        if (L >= R) {
            return arr;
        }
        int[] eqArrays = partition2(arr, L, R);
        quickSort2(arr, L, eqArrays[0] - 1);
        quickSort2(arr, eqArrays[1] + 1, R);

        return arr;
    }

    /**
     * 快排3.0   O(nlogn)
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] quickSort3(int[] arr, int L , int R)
    {
        if(L >= R)
        {
            return arr;
        }
        swap(arr, L+(int)Math.random()*(R-L+1),R);
        final int[] eqIndex = partition2(arr, L, R);
        quickSort3(arr, L, eqIndex[0] - 1);
        quickSort3(arr, eqIndex[1] + 1, R);
        return arr;
    }

    /**
     * 快排2.0 partition
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int[] partition2(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int pLeft = l - 1;
        int pRight = r;
        int index = l;
        while (index < pRight) {
            if (arr[index] == arr[r]) {
                index++;
            } else if (arr[index] < arr[r]) {
                swap(arr, index++, ++pLeft);
            } else {
                swap(arr, index, --pRight);
            }
        }
        swap(arr, r, pRight);
        return new int[]{pLeft + 1,pRight};
    }

    /**
     * 快排1.0 partition
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    private static int partition1(int[] arr, int L, int R) {
        int pLeft = L - 1;
        int pRight = R;
        int a = L;
        while (a < pRight) {
            if (arr[a] == arr[R]) {
                a++;
            } else if (arr[a] < arr[R]) {
                swap(arr, a++, ++pLeft);
            } else {
                swap(arr, a, --pRight);
            }
        }
        swap(arr, R, pRight);
        return pRight - 1;
    }

    private static void swap(int[] arr, int a, int i) {
        int tmp = arr[a];
        arr[a] = arr[i];
        arr[i] = tmp;
    }
}
