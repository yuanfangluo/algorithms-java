package Algorithms.其他常见算法技巧.经典面试题.一个方法解决三道区间问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/
public class _56_合并区间 {
    class Solution {
        // intervals 形如 [[1,3],[2,6]...]
        int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0)
                return new int[][] {};
            // 按区间的 start 升序排列
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            List<int[]> res = new ArrayList<>();
            res.add(intervals[0]);

            for (int i = 1; i < intervals.length; i++) {
                // 待合并区间
                int[] curr = intervals[i];
                // res 中最后一个元素的引用
                int[] last = res.get(res.size() - 1);
                // 待合并区间的开头比 res 中最后一个区间的末尾小
                // 说明他们可以合并
                if (curr[0] <= last[1]) {
                    // 找到最大的 end
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    // 处理下一个待合并区间
                    res.add(curr);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    }
}
