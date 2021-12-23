package com.hzq.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Leetcode_14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        final char[] chars = strs[0].toCharArray();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            int index = 0;
            final char[] temp = strs[i].toCharArray();
            while (index < temp.length && index < chars.length) {
                if (temp[index] == chars[index]) {
                    index++;
                } else {
                    break;
                }
            }
            min = Math.min(index,min);
            if(min == 0)
            {
                return "";
            }

        }
        return strs[0].substring(0,min);
    }
}
