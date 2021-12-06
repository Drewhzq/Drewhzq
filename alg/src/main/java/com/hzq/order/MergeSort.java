package com.hzq.order;

/**
 * 归并
 */
public class MergeSort {


    public static void main(String[] args) {
         int[] arr= new int[]{3,4,5,2,6,8,9,2,5,6,8};
         int[] arr1 = new int[]{1,3,4,2,5};
         //递归--归并
        //final int[] ints1 = process1(arr, 0, arr.length - 1);
        //Arrays.stream(ints1).forEach(System.out::println);
        //非递归---归并
//        final int[] ints2 = process2(arr);
//        Arrays.stream(ints2).forEach(System.out::println);

        //数组小和
        final int i = arraysSmallCount(arr1, 0, arr1.length - 1);
        System.out.println(i);
    }

    /**
     * 递归方式归并排序
     * 左边排好序，右边排好序，左边右边合并
     */
    public static int[] process1(int[] arr, int L, int R)
    {
        if(L == R)
        {
         return arr;
        }
        int M = L + ((R - L) >> 1);
        process1(arr, L, M);
        process1(arr,M+1, R);

        merge(arr,M, L, R);

        return arr;

    }


    /**
     * 非递归方式归并排序
     * @param arr
     * @return
     */
    public static int[] process2(int[] arr)
    {
        int sortSize = 1;
        int length = arr.length;
        while (sortSize < length)
        {
            int L = 0;
            while(L < length)
            {
                int M = L + sortSize;
                if(M > length)
                {
                    break;
                }
                int R = Math.min(M +sortSize,length-1);
                merge(arr,M, L, R);
                L += R + 1;
            }
            //防止溢出
            if(sortSize > length << 1)
            {
                break;
            }
            sortSize <<= 1;
        }
        return arr;
    }


    /**
     * 数组最小和
     * @param arr
     * @return
     */
    public static int arraysSmallCount(int[] arr, int L, int R)
    {
        if(L == R)
        {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return arraysSmallCount(arr, L, M) +
        arraysSmallCount(arr, M+1, R) +
        mergeXiaohe(arr, M, L, R);
    }

    /**
     * 数组最小和merge
     * @param arr
     * @param m
     * @param l
     * @param r
     */
    private static int mergeXiaohe(int[] arr, int m, int l, int r)
    {
        int[] help = new int[r - l +1];
        int pLeft = l;
        int pRight = m + 1;
        int i = 0;
        int sum = 0;
        while(pLeft < m + 1 && pRight < r + 1)
        {
            sum += arr[pLeft] < arr[pRight] ? arr[pLeft]*(r - pRight + 1) : 0;
            help[i++] = arr[pLeft] < arr[pRight] ? arr[pLeft++] : arr[pRight++];
        }

        while(pLeft < m + 1)
        {
            help[i++] = arr[pLeft++];
        }

        while(pRight < r + 1)
        {
            help[i++] = arr[pRight++];
        }
        for(int a = 0; a < help.length; a++)
        {
            arr[l + a] = help[a];
        }
        return sum;
    }

    /**
     * merge
     */
    private static void merge(int[] arr, int M, int L, int R)
    {
        //new 一个辅助数组
        int[] help = new int[R - L + 1];
        int pLeft = L;
        int pRight = M + 1;
        int i = 0;
        while (pLeft < M +1 && pRight < R + 1)
        {
            help[i++] = arr[pLeft] < arr[pRight] ? arr[pLeft++] : arr[pRight++];
        }
        while(pLeft < M + 1)
        {
            help[i++] = arr[pLeft++];
        }
        while(pRight < R + 1)
        {
            help[i++] = arr[pRight++];
        }

        for(int a = 0; a < help.length; a++)
        {
            arr[L+a] = help[a];
        }
    }
}
