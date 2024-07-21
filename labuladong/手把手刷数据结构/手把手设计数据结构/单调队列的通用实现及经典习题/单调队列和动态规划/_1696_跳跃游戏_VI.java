package labuladong.手把手刷数据结构.手把手设计数据结构.单调队列的通用实现及经典习题.单调队列和动态规划;

import java.util.Arrays;

import labuladong.Base.MonotonicQueue;

// https://leetcode.cn/problems/jump-game-vi/
public class _1696_跳跃游戏_VI {
    // 1425 题是让你求最大子序列和，子序列中每两个元素之间的间隔不能超过 k；
    // 这道题其实也是让你求元素间隔不超过 k 的最大子序列和，只不过又多了些限制，
    // 即子序列的第一个元素必须是 nums[0]，最后一个元素必须是 nums[-1]。

    // 第四步，利用单调队列结构消除内层循环（通过）
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            MonotonicQueue<Integer> window = new MonotonicQueue<>();
            // 定义：到达 nums[p] 的最大分数为 dp[p]
            int[] dp = new int[n];
            // dp 数组初始化为最小值
            Arrays.fill(dp, Integer.MIN_VALUE);
            // base case
            dp[0] = nums[0];
            window.push(dp[0]);
            // 状态转移
            for (int p = 1; p < n; p++) {
                dp[p] = window.max() + nums[p];
                // 维护窗口装着 dp[p-1..p-k]
                if (window.size() == k) {
                    window.pop();
                }
                window.push(dp[p]);
            }
            return dp[n - 1];
        }
    }

    // 第一步，暴力递归解法（超时）
    class Solution1 {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            return dp(nums, n - 1, k);
        }

        // 定义：到达 nums[p] 所能获得的最大分数是 dp(nums, p)
        // 能跳到 nums[p]，必然是从 nums[p-k..p-1] 中的某个位置跳来的
        // 故状态转移方程为：dp[p] = max(nums[p-k..p-1]) + nums[p]
        int dp(int[] nums, int p, int k) {
            if (p == 0) {
                return nums[0];
            }
            if (p < 0) {
                return Integer.MIN_VALUE;
            }
            // 实现状态转移方程
            int res = Integer.MIN_VALUE;
            for (int i = 1; i <= k; i++) {
                res = Math.max(res, dp(nums, p - i, k));
            }
            res += nums[p];
            return res;
        }
    }

    // 第二步，带备忘录的递归解法（超时）
    class Solution2 {
        // 备忘录
        int[] memo;

        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            memo = new int[n];
            // 备忘录初始化为最小值
            Arrays.fill(memo, Integer.MIN_VALUE);
            return dp(nums, n - 1, k);
        }

        // 定义：到达 nums[p] 所能获得的最大分数是 dp(nums, p)
        int dp(int[] nums, int p, int k) {
            if (p == 0) {
                return nums[0];
            }
            if (p < 0) {
                return Integer.MIN_VALUE;
            }
            // 查备忘录，避免冗余计算
            if (memo[p] != Integer.MIN_VALUE) {
                return memo[p];
            }
            // 实现状态转移方程，结果存入备忘录
            for (int i = 1; i <= k; i++) {
                memo[p] = Math.max(memo[p], dp(nums, p - i, k));
            }
            memo[p] += nums[p];
            return memo[p];
        }
    }

    // 第三步，自顶向下的递归改为自底向上的迭代解法（超时）
    class Solution3 {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            // 定义：到达 nums[p] 的最大分数为 dp[p]
            int[] dp = new int[n];
            // dp 数组初始化为最小值
            Arrays.fill(dp, Integer.MIN_VALUE);
            // base case
            dp[0] = nums[0];
            // 状态转移
            for (int p = 1; p < n; p++) {
                for (int i = 1; i <= k; i++) {
                    if (p - i < 0) {
                        continue;
                    }
                    dp[p] = Math.max(dp[p], dp[p - i]);
                }
                dp[p] += nums[p];
            }
            return dp[n - 1];
        }
    }

}