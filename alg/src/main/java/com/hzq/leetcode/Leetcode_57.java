package com.hzq.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leetcode_57 {

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

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals == null || newInterval == null) {
            return null;
        }
        Range[] ranges = new Range[intervals.length + 1];
        int i = 0;
        for (int[] tmp : intervals) {
            ranges[i] = new Range(tmp[0], tmp[1]);
            i++;
        }
        ranges[ranges.length - 1] = new Range(newInterval[0], newInterval[1]);

        Arrays.sort(ranges, new RangeCompactor());

        int start = ranges[0].start;
        int end = ranges[0].end;
        List<Range> list = new ArrayList<>();
        for (int j = 1; j < ranges.length; j++) {
            if (ranges[j].start > end) {
                list.add(new Range(start, end));
                start = ranges[j].start;
                end = ranges[j].end;
            } else {
                end = Math.max(end,ranges[j].end);
            }
        }
        list.add(new Range(start, end));

        return genreateArray(list);
    }

    private static int[][] genreateArray(List<Range> list) {

        int[][] res = new int[list.size()][2];
        int i = 0;
        for(Range range : list)
        {
            res[i] = new int[]{range.start,range.end};
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        insert(new int[][]{{1,3},{6,9}},new int[]{1,5});
    }
}
