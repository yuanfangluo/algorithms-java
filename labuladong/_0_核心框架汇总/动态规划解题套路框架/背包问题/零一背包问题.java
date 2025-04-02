package labuladong._0_核心框架汇总.动态规划解题套路框架.背包问题;

public class 零一背包问题 {

    int knapsack(int W, int N, int[] wt, int[] val) {
        // 物品和背包容量都是从1开始计数的
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) { // 当前背包容量装不下，只能选择不装入背包
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                            dp[i - 1][w - wt[i-1]] + val[i-1], // 装入背包，需要注意的是这里是 i-1，因为 wt 和 val 的数组索引是从 0 开始的
                            dp[i - 1][w] // 不装入背包
                    );
                }
            }
        }
        // 背包容量为 W，能够装入物品的最大值
        return dp[N][W];
    }

}
