package Algorithms.经典动态规划算法.贪心类型问题.区间调度问题;

import java.util.Arrays;

// https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
public class _452_用最少数量的箭引爆气球 {
    class Solution {
        int findMinArrowShots(int[][] intvs) {
            if (intvs.length == 0)
                return 0;
            // 按 end 升序排序
            Arrays.sort(intvs, (a, b) -> Integer.compare(a[1], b[1]));
            // 至少有一个区间不相交
            int count = 1;
            // 排序后，第一个区间就是 x
            int x_end = intvs[0][1];
            for (int[] interval : intvs) {
                int start = interval[0];
                // 把 >= 改成 > 就行了
                if (start > x_end) {
                    count++;
                    x_end = interval[1];
                }
            }
            return count;
        }
    }
}
