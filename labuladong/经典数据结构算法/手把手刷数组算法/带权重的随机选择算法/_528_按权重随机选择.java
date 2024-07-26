package labuladong.经典数据结构算法.手把手刷数组算法.带权重的随机选择算法;

import java.util.Random;

// https://leetcode.cn/problems/random-pick-with-weight/description/
public class _528_按权重随机选择 {
    // 1、根据权重数组 w 生成前缀和数组 preSum。
    // 2、生成一个取值在 preSum 之内的随机数，用二分搜索算法寻找大于等于这个随机数的最小元素索引。
    // 3、最后对这个索引减一（因为前缀和数组有一位索引偏移），就可以作为权重数组的索引，即最终答案:

    class Solution {
        // 前缀和数组
        private int[] preSum;
        private Random rand = new Random();

        public Solution(int[] w) {
            int n = w.length;
            // 构建前缀和数组，偏移一位留给 preSum[0]
            preSum = new int[n + 1];
            preSum[0] = 0;
            // preSum[i] = sum(w[0..i-1])
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + w[i - 1];

            }
        }

        public int pickIndex() {
            int n = preSum.length;
            // Java 的 nextInt(n) 方法在 [0, n) 中生成一个随机整数
            // 再加一就是在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
            int target = rand.nextInt(preSum[n - 1]) + 1;

            // 获取 target 在前缀和数组 preSum 中的索引
            // 别忘了前缀和数组 preSum 和原始数组 w 有一位索引偏移
            return left_bound(preSum, target) - 1;
        }

        // 搜索左侧边界的二分搜索
        private int left_bound(int[] nums, int target) {
            if (nums.length == 0)
                return -1;
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            return left;
        }
    }
}
