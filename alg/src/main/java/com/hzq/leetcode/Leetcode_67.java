package com.hzq.leetcode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
public class Leetcode_67 {

    public static String addBinary(String a, String b) {

        if(a == null || b == null || a.isEmpty() || b.isEmpty() )
        {
            return "";
        }
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        int indexA = charA.length -1;
        int indexB = charB.length - 1;
        int[] res = new int[Math.max(indexA+1,indexB+1)+1];
        int bit = 0;
        int resIndex = res.length - 1;
        while(indexA >=0 && indexB >= 0)
        {
            int tmp = charA[indexA--] - '0' + charB[indexB--] - '0';
            res[resIndex--] = (tmp + bit) % 2;
            bit = (tmp + bit) / 2 ;
        }
        while(indexA >= 0)
        {
            res[resIndex--] = (charA[indexA] - '0' + bit) % 2;
            bit = (charA[indexA--] - '0' + bit) / 2;
        }
        while(indexB >= 0)
        {
            res[resIndex--] = (charB[indexB] - '0' + bit) % 2;
            bit = (charB[indexB--] - '0' + bit) / 2;
        }

        if(bit != 0)
        {
            res[resIndex] = bit;
        }
        StringBuilder sb = new StringBuilder();
        if(res[0] != 0)
        {
            sb.append(res[0]);
        }
        for(int i = 1; i < res.length;i++)
        {
            sb.append(res[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("110010","10111"));
    }
}
