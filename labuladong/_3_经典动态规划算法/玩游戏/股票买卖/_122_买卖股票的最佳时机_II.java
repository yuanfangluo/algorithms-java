package labuladong._3_经典动态规划算法.玩游戏.股票买卖;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
public class _122_买卖股票的最佳时机_II {
    
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            // 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
            // 定义状态
            // dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润
            // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润（i 从 0 开始）。
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                // 第 i 天交易完后手里没有股票的最大利润 = 第 i - 1 天交易完后手里没有股票的最大利润 
                // 或者 第 i - 1 天交易完后手里持有一支股票的最大利润 + 第 i 天卖出股票的价格
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                // 第 i 天交易完后手里持有一支股票的最大利润 = 第 i - 1 天交易完后手里持有一支股票的最大利润 
                // 或者 第 i - 1 天交易完后手里没有股票的最大利润 - 第 i 天买入股票的价格
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            // 最后一天手里没有股票的最大利润
            return dp[n - 1][0];
        }
    }

    // 优化
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int dp0 = 0, dp1 = -prices[0];
            for (int i = 1; i < n; ++i) {
                int newDp0 = Math.max(dp0, dp1 + prices[i]);
                int newDp1 = Math.max(dp1, dp0 - prices[i]);
                dp0 = newDp0;
                dp1 = newDp1;
            }
            return dp0;
        }
    }
}
