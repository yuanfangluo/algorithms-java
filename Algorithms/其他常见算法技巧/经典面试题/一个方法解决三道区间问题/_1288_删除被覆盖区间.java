package Algorithms.其他常见算法技巧.经典面试题.一个方法解决三道区间问题;

import java.util.Arrays;

// https://leetcode.cn/problems/remove-covered-intervals/
public class _1288_删除被覆盖区间 {
    // 那么我们可以先算一算，被覆盖区间有多少个，然后和总数相减就是剩余区间数。
    int removeCoveredIntervals(int[][] intvs) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intvs, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点
        int left = intvs[0][0];
        int right = intvs[0][1];

        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            int[] intv = intvs[i];
            // 情况一，找到覆盖区间
            if (left <= intv[0] && right >= intv[1]) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            // 情况三，完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intvs.length - res;
    }
}
