package com.hzq.order;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,5,6,8,9,35,89,31,5,45,124};
        Arrays.stream(radixSort(arr)).forEach(System.out::println);
    }

    public static int[] radixSort(int[] arr)
    {
        if(arr == null ||arr.length == 1)
        {
            return arr;
        }

        process(arr, 0, arr.length-1,bitCount(arr));
        return arr;
    }

    private static void process(int[] arr, int l, int r, int bitCount) {

       int[] blocklet = new int[r-l+1];
        for(int i = 1; i<bitCount+1;i++)
        {
            //help 数组的索引即为个位 十位...的值，索引上的值是几，则出现过几次
            int[] help = new int[10];
            for(int j = l ; j<=r; j++)
            {
                help[getDigt(arr[j],i)]++;
            }

            /**
             * 以个位举例，help[7] = 4代表 数组中个位比7小的有4个
             */
            for(int k = 1; k<help.length;k++)
            {
                help[k] +=help[k-1];
            }

            /**
             * 以个位举例，help[7] = 4代表 数组中个位比7小的有4个
             * 则从后向前遍历数组，最后一位数最后出队，则它的位置在比他个位小的数中肯定是最后一个
             *
             */
            for(int m = r; m >=l; m--)
            {
                blocklet[help[getDigt(arr[m], i)]-1] = arr[m];
                help[getDigt(arr[m], i)]--;
            }

            /**
             * 个位上的数字有序
             */
            for(int m = l,n=0;m<=r;m++,n++)
            {
                arr[m] = blocklet[n];
            }
        }



    }

    private static int getDigt(int i, int bit) {
        return (i/(int)Math.pow(10,bit-1)) % 10;
    }

    private static int bitCount(int[] arr) {

        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++)
        {
           max = Math.max(max, arr[i]);
        }
        int res = 0;
        while(max != 0)
        {
            res++;
            max /= 10;
        }
        return res;
    }
}
