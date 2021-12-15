package com.hzq.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Leetcode_3 {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {

            while (end < chars.length && !set.contains(chars[end])) {
                set.add(chars[end]);
                end++;
            }
            res = Math.max(res, end - start);
            set.remove(chars[start]);
            start++;
        }
        return res;
    }

    /**
     * 高级做法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s)
    {
        if(s == null || s.isEmpty())
        {
            return 0;
        }
        int[] map = new int[256];
        for(int i = 0; i<map.length;i++)
        {
            map[i] = -1;
        }
        int len = 0;
        int per = -1;
        int cur = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i<chars.length;i++)
        {
            per = Math.max(per,map[chars[i]]);
            cur = i - per;
            len = Math.max(cur, len);
            map[chars[i]] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcabccccc"));
    }
}
