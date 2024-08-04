package Algorithms.经典动态规划算法.贪心类型问题.剪视频;

import java.util.Arrays;

// https://leetcode.cn/problems/video-stitching/
public class _1024_视频拼接 {
    // 区间问题肯定按照区间的起点或者终点进行排序。
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            if (T == 0)
                return 0;
            // 按起点升序排列，起点相同的按终点降序排列
            Arrays.sort(clips, (a, b) -> {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            });
            
            // 记录选择的短视频个数
            int res = 0;

            int curEnd = 0, nextEnd = 0;
            int i = 0, n = clips.length;
            while (i < n && clips[i][0] <= curEnd) {
                // 在第 res 个视频的区间内贪心选择下一个视频
                while (i < n && clips[i][0] <= curEnd) {
                    nextEnd = Math.max(nextEnd, clips[i][1]);
                    i++;
                }
                // 找到下一个视频，更新 curEnd
                res++;
                curEnd = nextEnd;
                if (curEnd >= T) {
                    // 已经可以拼出区间 [0, T]
                    return res;
                }
            }
            // 无法连续拼出区间 [0, T]
            return -1;
        }
    }

}
