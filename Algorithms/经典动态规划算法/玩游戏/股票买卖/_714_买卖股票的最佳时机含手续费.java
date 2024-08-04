package Algorithms.经典动态规划算法.玩游戏.股票买卖;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class _714_买卖股票的最佳时机含手续费 {

    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            // 考虑到「不能同时参与多笔交易」，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
            int[][] dp = new int[n][2];
            // dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润
            // dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
            // 初始状态：    第 0 天交易完后手里没有股票，利润为 0
            // 初始状态：    第 0 天交易完后手里持有一支股票，利润为 -prices[0]
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < n; ++i) {
                // 如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票或者前一天持有股票卖出
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
                // 如果这一天交易完后手里持有一支股票，那么可能的转移状态为前一天已经持有股票或者前一天没有股票但是买入股票
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
            return dp[n - 1][0];
        }
    }

    // 空间优化
    class Solution2 {
        public int maxProfit(int[] prices, int fee) {
            int n = prices.length;
            int sell = 0, buy = -prices[0];
            for (int i = 1; i < n; ++i) {
                sell = Math.max(sell, buy + prices[i] - fee);
                buy = Math.max(buy, sell - prices[i]);
            }
            return sell;
        }
    }
}
