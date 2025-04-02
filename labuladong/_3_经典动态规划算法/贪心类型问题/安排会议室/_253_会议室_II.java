package labuladong._3_经典动态规划算法.贪心类型问题.安排会议室;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/meeting-rooms-ii/
public class _253_会议室_II {
    // 如果会议之间的时间有重叠，那就得额外申请会议室来开会，
    // 想求至少需要多少间会议室，就是让你计算同一时刻最多有多少会议在同时进行。

    // 这样一来，每个时刻有多少个会议在同时进行，就是计数器 count 的值，count 的最大值，就是需要申请的会议室数量。

    // 扫描线从左向右前进，遇到红点就对计数器加一，遇到绿点就对计数器减一，计数器 count 的最大值就是答案

    class Solution2 {
        int minMeetingRooms(int[][] meetings) {
            int n = meetings.length;
            int[] begin = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                begin[i] = meetings[i][0];
                end[i] = meetings[i][1];
            }
            Arrays.sort(begin);
            Arrays.sort(end);

            // 扫描过程中的计数器
            int count = 0;
            // 双指针技巧
            int res = 0, i = 0, j = 0;
            while (i < n && j < n) {
                if (begin[i] < end[j]) {
                    // 扫描到一个红点
                    count++;
                    i++;
                } else {
                    // 扫描到一个绿点
                    count--;
                    j++;
                }
                // 记录扫描过程中的最大值
                res = Math.max(res, count);
            }

            return res;
        }
    }

    class Solution1 {
        public int minMeetingRooms(int[][] intervals) {
            if (intervals == null || intervals.length == 0)
                return 0;
            // 按照会议的开始时间，从小到大排序 nlogn
            Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
            // 创建一个最小堆（存放每一个会议的结束时间）
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            // 添加0号会议的结束时间
            heap.add(intervals[0][1]);
            // 堆顶的含义：目前占用的会议室中最早结束的时间
            for (int i = 1; i < intervals.length; i++) { // nlogn
                // i号会议的开始时间 >= 堆顶
                if (intervals[i][0] >= heap.peek()) {
                    heap.remove();
                }
                // 将i号会议的结束时间加入堆中
                heap.add(intervals[i][1]);
            }

            return heap.size();
        }
    }
}
