package labuladong.经典动态规划算法.贪心类型问题.区间调度问题;

import java.util.Arrays;

// https://leetcode.cn/problems/non-overlapping-intervals/
public class _435_无重叠区间 {
    class Solution {
        int eraseOverlapIntervals(int[][] intervals) {
            int n = intervals.length;
            return n - intervalSchedule(intervals);
        }

        // 给你很多形如 [start, end] 的闭区间，请你设计一个算法，算出这些区间中最多有几个互不相交的区间。
        public int intervalSchedule(int[][] intvs) {
            if (intvs.length == 0) return 0;
            // 按 end 升序排序
            Arrays.sort(intvs, (a, b) -> Integer.compare(a[1], b[1]));
            // 至少有一个区间不相交
            int count = 1;
            // 排序后，第一个区间就是 x
            int x_end = intvs[0][1];
            for (int[] interval : intvs) {
                // 第一个interval实际上可以省略
                int start = interval[0];
                if (start >= x_end) {
                    // 找到下一个选择的区间了
                    count++;
                    x_end = interval[1];
                }
            }
            return count;
        }
    }
}
