package labuladong.Array.滑动窗口.扩展;
/*
* https://leetcode.cn/problems/minimum-size-subarray-sum/?show=1
*
* */
public class _209_长度最小的子数组 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        // 维护窗口内元素之和
        int windowSum = 0;
        int res = Integer.MAX_VALUE;

        while (right < nums.length) {
            // 扩大窗口
            windowSum += nums[right];
            right++;
            while (windowSum >= target && left < right) {
                // 已经达到 target，缩小窗口，同时更新答案
                res = Math.min(res, right - left);
                windowSum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
