package com.hzq.leetcode;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_76 {

    public String minWindow(String s, String t) {

        if(s.length() < t.length())
        {
            return "";
        }

        //欠账表
        int[] map = new int[256];
        int all = 0;
        char[] charS = s.toCharArray();
        char[] charT= t.toCharArray();
        for(char ch :charT)
        {
            map[ch]++;
            all++;
        }

        int left = 0;
        int right = 0;

        int minLength = -1;
        int ansL = -1;
        int ansR = -1;

        while(right < s.length())
        {
           map[charS[right]]--;
           if(map[charS[right]] >= 0)
           {
               all--;
           }

           if(all == 0)
           {
               while(map[charS[left]] < 0)
               {
                   map[charS[left]]++;
                   left++;
               }

               if(minLength == -1 || minLength > right - left + 1)
               {
                   ansL = left;
                   ansR = right;
                   minLength = right - left + 1;
               }
               map[charS[left++]]++;
               all++;
           }
           right++;
        }
        return minLength == -1 ? "" : s.substring(ansL,ansR+1);
    }
}
