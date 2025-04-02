package labuladong._3_经典动态规划算法.背包类型问题.完全背包问题;

// https://leetcode.cn/problems/coin-change-ii/
public class _518_零钱兑换_II {
    class Solution1 {
        int change(int amount, int[] coins) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            // base case
            for (int i = 0; i <= n; i++)
                dp[i][0] = 1;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++)
                    if (j - coins[i - 1] >= 0)
                        dp[i][j] = dp[i - 1][j]
                                + dp[i][j - coins[i - 1]];
                    else
                        dp[i][j] = dp[i - 1][j];
            }
            return dp[n][amount];
        }
    }
    // 空间压缩
    class Solution2 {
        int change(int amount, int[] coins) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            dp[0] = 1; // base case
            for (int i = 0; i < n; i++)
                for (int j = 1; j <= amount; j++)
                    if (j - coins[i] >= 0)
                        dp[j] = dp[j] + dp[j-coins[i]];
            
            return dp[amount];
        }
    }
}
