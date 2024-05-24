package labuladong.Array.快慢指针.滑动窗口.扩展;

import labuladong.Base.MonotonicQueue;

/*
* https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/?show=1
*
*
* */
public class _1438_绝对差不超过限制的最长连续子数组 {

    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int windowSize = 0, res = 0;
        MonotonicQueue<Integer> window = new MonotonicQueue();
        // 滑动窗口模板
        while (right < nums.length) {
            // 扩大窗口，更新窗口最值
            window.push(nums[right]);
            right++;
            windowSize++;
            while ((window.max() - window.min()) > limit) {
                // 缩小窗口，更新窗口最值
                window.pop();
                left++;
                windowSize--;
            }
            // 在窗口收缩判断完之后才更新答案
            res = Math.max(res, windowSize);
        }
        return res;
    }
}
