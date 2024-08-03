package Algorithms._3_经典动态规划算法.玩游戏.股票买卖;

import java.util.Arrays;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
public class _188_买卖股票的最佳时机_IV {

    // 与其余的股票问题类似，我们使用一系列变量存储「买入」的状态，再用一系列变量存储「卖出」的状态，
    // 通过动态规划的方法即可解决本题。

    // 我们用 buy[i][j] 表示对于数组 prices[0..i] 中的价格而言，进行恰好 j 笔交易，
    // 并且当前手上持有一支股票，这种情况下的最大利润；

    // 用 sell[i][j] 表示恰好进行 j 笔交易，并且当前手上不持有股票，这种情况下的最大利润。

    // 对于 buy[i][j]，我们考虑当前手上持有的股票是否是在第 i 天买入的。
    // 如果是第 i 天买入的，那么在第 i−1 天时，我们手上不持有股票，对应状态 sell[i−1][j]，并且需要扣除 prices[i] 的买入花费；
    // 如果不是第 i 天买入的，那么在第 i−1 天时，我们手上持有一支股票，对应状态 buy[i−1][j]。
    // 因此，我们可以列出如下的状态转移方程：
    // buy[i][j] = max(buy[i−1][j], sell[i−1][j] − prices[i])
    // 对于 sell[i][j]，我们考虑当前手上持有的股票是否是在第 i 天卖出的。
    // 如果是第 i 天卖出的，那么在第 i−1 天时，我们手上持有一支股票，对应状态 buy[i−1][j−1]，并且需要加上 prices[i] 的卖出收益；
    // 如果不是第 i 天卖出的，那么在第 i−1 天时，我们手上不持有股票，对应状态 sell[i−1][j]。
    // 因此，我们可以列出如下的状态转移方程：
    // sell[i][j] = max(sell[i−1][j], buy[i−1][j−1] + prices[i])

    // 由于在所有的 n 天结束后，手上不持有股票对应的最大利润一定是严格由于手上持有股票对应的最大利润的，
    // 然而完成的交易数并不是越多越好（例如数组 prices 单调递减，我们不进行任何交易才是最优的）
    // 最终的答案即为 sell[n−1][0..k] 中的最大值

    class Solution {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int n = prices.length;
            k = Math.min(k, n / 2);

            int[][] buy = new int[n][k + 1];
            int[][] sell = new int[n][k + 1];

            buy[0][0] = -prices[0];
            sell[0][0] = 0;
            for (int i = 1; i <= k; ++i) {
                buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
            }

            for (int i = 1; i < n; ++i) {
                buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                    sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
                }
            }

            return Arrays.stream(sell[n - 1]).max().getAsInt();
        }
    }

    // 对于这两个状态转移方程，它们的状态转移只和第 i−1 天的状态有关，因此我们可以使用两个一维数组 buy 和 sell 交替记录，
    // 而不是使用一个二维数组。
    // 这样可以将空间复杂度降低到 O(K)。
    class Solution2 {
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0) {
                return 0;
            }
    
            int n = prices.length;
            k = Math.min(k, n / 2);
            int[] buy = new int[k + 1];
            int[] sell = new int[k + 1];
    
            buy[0] = -prices[0];
            sell[0] = 0;
            for (int i = 1; i <= k; ++i) {
                buy[i] = sell[i] = Integer.MIN_VALUE / 2;
            }
    
            for (int i = 1; i < n; ++i) {
                buy[0] = Math.max(buy[0], sell[0] - prices[i]);
                for (int j = 1; j <= k; ++j) {
                    buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                    sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);   
                }
            }
    
            return Arrays.stream(sell).max().getAsInt();
        }
    }
}
