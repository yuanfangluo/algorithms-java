package labuladong.经典数据结构算法.手把手设计数据结构.单调队列的通用实现及经典习题.单调队列和动态规划;

import labuladong.Base.MonotonicQueue;

// https://leetcode.cn/problems/constrained-subsequence-sum/
public class _1425_带限制的子序列和 {
    // 设计一个 dp 数组，dp[i] 表示以 nums[i] 为结尾的最大子序列之和，
    // 然后题目要求的答案就是 max(dp[..])。

    // 经过单调队列优化的动态规划解法
    class Solution {
        public int constrainedSubsetSum(int[] nums, int k) {
            int n = nums.length;
            // 定义：dp[i] 表示以 nums[i] 结尾的子序列的最大和
            int[] dp = new int[n];
            dp[0] = nums[0];
            // 单调队列辅助计算 dp[i-k..i-1] 的最大值
            MonotonicQueue<Integer> window = new MonotonicQueue<>();
            window.push(dp[0]);

            for (int i = 1; i < n; i++) {
                // 状态转移方程
                dp[i] = Math.max(nums[i], window.max() + nums[i]);
                // 维护滑动窗口的大小为 k
                if (window.size() == k) {
                    window.pop();
                }
                window.push(dp[i]);
            }
            // dp 数组中的最大值就是结果
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }

        // 单调队列的通用实现，可以高效维护最大值和最小值
        // 由于我这里考虑了泛型和通用性，所以提交的性能会略差，你可自行精简
    }
}
