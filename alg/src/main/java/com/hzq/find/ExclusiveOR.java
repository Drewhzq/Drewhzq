package com.hzq.find;

/**
 * 一个数组中，有两种数出现奇数次，别的数都出现偶数次，求出现奇数次的数
 */
public class ExclusiveOR {

    public static int[] getUnevenNums(int[] arrays)
    {
        int exc = 0;
        for(int i = 0; i < arrays.length; i++)
        {
            exc ^= arrays[i];
        }
        //找出这两个奇数某个位上0和1
        int bitCount = exc & (~exc + 1);

        int a = 0;
        for(int i = 0; i < arrays.length; i++)
        {
            if((arrays[i] & bitCount) == 0)
            {
                a ^= arrays[i];
            }
        }
        final int[] ints = new int[2];
        ints[0] = a;
        ints[1] = a^exc;
        return ints;
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1,1,1,2,2,2,2,3,3,3,4,4};
        final int[] i = getUnevenNums(arrays);
        System.out.println(i[0]+","+i[1]);
    }

}
