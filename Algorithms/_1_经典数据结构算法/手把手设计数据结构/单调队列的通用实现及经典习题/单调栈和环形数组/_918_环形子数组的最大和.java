package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调队列的通用实现及经典习题.单调栈和环形数组;

import Algorithms.Base.MonotonicQueue;

// https://leetcode.cn/problems/maximum-sum-circular-subarray/
public class _918_环形子数组的最大和 {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            // 模拟环状的 nums 数组
            int[] preSum = new int[2 * n + 1];
            preSum[0] = 0;
            // 计算环状 nums 的前缀和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
            }
            // 记录答案
            int maxSum = Integer.MIN_VALUE;
            // 维护一个滑动窗口，以便根据窗口中的最小值计算最大子数组和
            MonotonicQueue<Integer> window = new MonotonicQueue<>();
            window.push(0);
            for (int i = 1; i < preSum.length; i++) {
                maxSum = Math.max(maxSum, preSum[i] - window.min());
                // 维护窗口的大小为 nums 数组的大小
                if (window.size() == n) {
                    window.pop();
                }
                window.push(preSum[i]);
            }
            return maxSum;
        }
    }
    
}
