package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_39 {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        int rest = target;
        process(candidates, 0,rest, list, res);
        return res;

    }

    private static void process(int[] candidates, int index, int rest, List<Integer> list, List<List<Integer>> res) {

        if(index == candidates.length)
        {
            return;
        }
        if(rest == 0)
        {
            res.add(new ArrayList<>(list));
            return;
        }

        //选择当前的数
        if(rest-candidates[index] >= 0)
        {
            list.add(candidates[index]);
            process(candidates, index, rest-candidates[index],list,res);
            list.remove(list.size()-1);
        }
        //选择下一个数
        process(candidates,index + 1, rest, list,res);

    }


    public static void main(String[] args) {
        final List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
