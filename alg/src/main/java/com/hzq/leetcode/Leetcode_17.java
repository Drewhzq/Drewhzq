package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Leetcode_17 {

    static char[][] numToStr = new char[][]{
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0)
        {
            return res;
        }
        char[] chars = digits.toCharArray();
        char[] path = new char[chars.length];
        process(chars,0, path,res);
        return res;

    }

    /**
     * 暴力递归
     * @param chars
     * @param index
     * @param path
     * @param res
     */
    private static void process(char[] chars, int index, char[] path, List<String> res)
    {

        if(index == chars.length)
        {
            res.add(new String(path));
            return;
        }
        char[] ch = numToStr[chars[index] - '2'];
        for(char c : ch)
        {
            path[index] = c;
            process(chars,index+1,path,res);
        }
    }
}
