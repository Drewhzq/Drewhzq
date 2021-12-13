package com.hzq.leetcode;

/**
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 * 用位运算的技巧就行了。。。
 *
 * 大写变小写、小写变大写 : 字符 ^= 32;
 *
 * 大写变小写、小写变小写 : 字符 |= 32;
 *
 * 小写变大写、大写变大写 : 字符 &= -33;
 */
public class Leetcode_709 {

    public static String toLowerCase(String s) {

        if(s == null || s.isEmpty())
        {
            return s;
        }
        char[] chars = s.toCharArray();
        for(int i = 0;i<chars.length;i++)
        {
            if(chars[i] <= 'Z' && chars[i] >= 'A')
            {
                chars[i] +=32;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase("al&phaBET"));
    }
}
