package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_60 {

    public static String getPermutation(int n, int k) {

        if (n < 1 || k < 0) {
            return "";
        }
        List<String> res = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        generateRes(res, nums, 0);
        Collections.sort(res);
        return res.get(k);
    }

    private static void generateRes(List<String> res, int[] nums, int index) {

        if (index == nums.length) {
            StringBuilder sb = new StringBuilder();
            for (int a : nums) {
                sb.append(a);
            }
            res.add(sb.toString());
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            generateRes(res, nums, index + 1);
            swap(nums, i, index);
        }
    }

    private static void swap(int[] nums, int i, int index) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }

    public static String getPermutation1(int n, int k) {

        if (n < 1 || k < 0) {
            return "";
        }
        int allResCount = 1;
        int n1 = n;
        while (n1 != 1) {
            allResCount *= n1;
            n1--;
        }

        int recordNum = 1;
        int num = 0;
        while (k >= recordNum) {
            recordNum += (allResCount / n);
            num++;
        }

        List<String> res = new ArrayList<>();
        int[] nums = new int[n - 1];
        for (int i = 1,j = 0; i <= n; i++) {
            if (i != num) {
                nums[j] = i;
                j++;
            }
        }

        generateRes(res, nums, 0);
        Collections.sort(res);
        return num+res.get(allResCount / n - (recordNum - k) - 1);


    }

    public static void main(String[] args) {
        getPermutation1(5, 25);
    }
}
