package labuladong.Array.滑动窗口;

import labuladong.Base.MonotonicQueue;

/*
 * https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/?show=1
 * 结合了 滑动窗口算法、前缀和技巧 和 单调队列 几个知识点
 *
 * 首先，想要快速记录子数组的和，需要 前缀和技巧 预计算一个 preSum 数组，
 * 然后在这个 preSum 数组上施展 滑动窗口算法 寻找一个差值大于 k 且宽度最小的「窗口」，这个窗口的大小就是题目想要的结果。
 *
 * 这里面还有个问题，当滑动窗口扩大时，新进入窗口的元素 preSum[right] 需要知道窗口中最小的那个元素是多少，
 * 和最小的那个元素相减才能得到尽可能大的子数组和。
 * 如何快速判断窗口中的最值？这就需要单调队列结构出马了，直接看解法代码吧。
 * */
public class _862_和至少为K的最短子数组 {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        // 看题目的数据范围，前缀和数组中元素可能非常大，所以用 long 类型
        long[] preSum = new long[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和数组
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 单调队列结构辅助滑动窗口算法
        MonotonicQueue<Long> window = new MonotonicQueue<>();

        int left = 0, right = 0;
        int len = Integer.MAX_VALUE;
        // 开始执行滑动窗口算法框架
        while (right < preSum.length) {
            // 扩大窗口，元素入队
            window.push(preSum[right]);
            right++;
            // 若新进入窗口的元素和窗口中的最小值之差大于等于 k，
            // 说明得到了符合条件的子数组，缩小窗口，使子数组长度尽可能小
            while (right < preSum.length && !window.isEmpty()
                    && preSum[right] - window.min() >= k) {
                // 更新答案
                len = Math.min(len, right - left);
                // 缩小窗口
                window.pop();
                left++;
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}
