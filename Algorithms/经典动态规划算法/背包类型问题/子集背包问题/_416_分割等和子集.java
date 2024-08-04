package Algorithms.经典动态规划算法.背包类型问题.子集背包问题;

// https://leetcode.cn/problems/partition-equal-subset-sum/
public class _416_分割等和子集 {
    // 给一个可装载重量为 sum / 2 的背包和 N 个物品，每个物品的重量为 nums[i]。
    // 现在让你装物品，是否存在一种装法，能够恰好将背包装满？

    class Solution1 {
        boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0)
                return false;

            int n = nums.length;
            sum = sum / 2;
            boolean[][] dp = new boolean[n + 1][sum + 1];
            // base case
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    if (j - nums[i - 1] < 0) {
                        // 背包容量不足，不能装入第 i 个物品
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        // 装入或不装入背包
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[n][sum];
        }
    }

    // 空间优化
    class Solution2 {
        boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums)
                sum += num;
            // 和为奇数时，不可能划分成两个和相等的集合
            if (sum % 2 != 0)
                return false;
            int n = nums.length;
            sum = sum / 2;
            boolean[] dp = new boolean[sum + 1];

            // base case
            dp[0] = true;

            for (int i = 0; i < n; i++) {
                // 唯一需要注意的是 j 应该从后往前反向遍历，
                // 因为每个物品（或者说数字）只能用一次，以免之前的结果影响其他的结果。
                for (int j = sum; j >= 0; j--) {
                    if (j - nums[i] >= 0) {
                        dp[j] = dp[j] || dp[j - nums[i]];
                    }
                }
            }
            return dp[sum];
        }
    }
}
