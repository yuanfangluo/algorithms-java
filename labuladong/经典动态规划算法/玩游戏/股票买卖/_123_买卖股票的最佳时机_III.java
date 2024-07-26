package labuladong.经典动态规划算法.玩游戏.股票买卖;

// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
public class _123_买卖股票的最佳时机_III {
    // 由于我们最多可以完成两笔交易，因此在任意一天结束之后，我们会处于以下五个状态中的一种：
    // 未进行过任何操作；
    // 只进行过一次买操作；
    // 进行了一次买操作和一次卖操作，即完成了一笔交易；
    // 在完成了一笔交易的前提下，进行了第二次买操作；
    // 完成了全部两笔交易。
    // 由于第一个状态的利润显然为 0，因此我们可以不用将其记录。
    // 对于剩下的四个状态，我们分别将它们的最大利润记为 buy1, sell1, buy2, sell2。
    // 如果我们知道了第 i−1 天结束后的这四个状态，那么如何通过状态转移方程得到第 i 天结束后的这四个状态呢？

    // 对于 buy1，它可能由两个状态转移而来：
    // 我们在第 i−1 天结束时持有股票，那么就保持 buy1 不变；
    // 我们在第 i−1 天结束时没有持有股票，那么就可以买入股票，因此状态转移方程为：
    // buy1 = max(buy1, -prices[i])

    // 对于 sell1，它可能由两个状态转移而来：
    // 我们在第 i−1 天结束时卖出股票，那么就保持 sell1 不变；
    // 我们在第 i−1 天结束时持有股票，那么就可以卖出股票，因此状态转移方程为：
    // sell1 = max(sell1, buy1 + prices[i])

    // 对于 buy2，它可能由两个状态转移而来：
    // 我们在第 i−1 天结束时持有股票，那么就保持 buy2 不变；
    // 我们在第 i−1 天结束时没有持有股票，那么就可以买入股票，因此状态转移方程为：
    // buy2 = max(buy2, sell1 - prices[i])

    // 对于 sell2，它可能由两个状态转移而来：
    // 我们在第 i−1 天结束时卖出股票，那么就保持 sell2 不变；
    // 我们在第 i−1 天结束时持有股票，那么就可以卖出股票，因此状态转移方程为：
    // sell2 = max(sell2, buy2 + prices[i])

    // 在动态规划结束后，由于我们可以进行不超过两笔交易，因此最终的答案在 0，sell1，sell2中，且为三者中的最大值。
    // 然而我们可以发现，由于在边界条件中 sell1和 sell2的值已经为 0，并且在状态转移的过程中我们维护的是最大值，
    // 因此 sell1和 sell2最终一定大于等于 0。
    // 同时，如果最优的情况对应的是恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，
    // 从 sell1转移至 sell2，因此最终的答案即为 sell2
    public int maxProfit(int[] prices) {
        // 以 prices[0] 的价格买入股票
        int buy1 = -prices[0];
        // 在同一天买入并且卖出
        int sell1 = 0;
        // 在同一天买入并且卖出后再以 prices[0] 的价格买入股票
        int buy2 = -prices[0];
        // 在同一天买入并且卖出后再以 prices[0] 的价格买入股票再次卖出
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
