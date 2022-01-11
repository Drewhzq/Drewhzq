package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_56 {


    static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class RangeCompactor implements Comparator<Range> {

        @Override
        public int compare(Range o1, Range o2) {
            return o1.start - o2.start;
        }
    }

    public static int[][] merge(int[][] intervals) {

        Range[] ranges = new Range[intervals.length];
        if (intervals == null || intervals.length == 0) {
            return null;
        }
        for (int i = 0; i < intervals.length; i++) {
            ranges[i] = new Range(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(ranges, new RangeCompactor());

        List<Range> res = new ArrayList<>();

        int start = ranges[0].start;
        int end = ranges[0].end;

        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i].start > end) {
                res.add(new Range(start, end));
                start = ranges[i].start;
                end = ranges[i].end;
            } else {
                 end = Math.max(end,ranges[i].end);
            }
        }
        //加最后一个区间
        res.add(new Range(start,end));
        return generateArray(res);

    }

    private static int[][] generateArray(List<Range> res) {
        int[][] array = new int[res.size()][2];
        int i = 0;
        for(Range range : res)
        {
            array[i] = new int[]{range.start,range.end};
            i++;
        }
        return array;
    }
}
