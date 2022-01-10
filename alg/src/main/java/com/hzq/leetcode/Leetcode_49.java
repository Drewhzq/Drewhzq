package com.hzq.leetcode;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_49 {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return res;
        }
        Map<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            final String s = new String(chars);
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            } else {
                map.get(s).add(str);
            }
        }
        for(Map.Entry<String,List<String>> entry : map.entrySet())
        {
            res.add(entry.getValue());
        }
        return res;
    }
}
