package Algorithms._3_经典动态规划算法.背包类型问题.零一背包问题;

public class 框架代码 {
    // 0-1 背包问题的暴力递归解法
    // 考虑将物品 i 装入背包或者不装入背包，暴力递归的思路是：
    // 把物品 i 装入背包，背包容量减少 wt[i]，价值增加 val[i]，然后递归调用函数，
    // 此时背包容量为 W - wt[i]，价值为 val[i]；
    // 不装入背包，背包容量不变，价值不变，然后递归调用函数，此时背包容量为 W，价值为 val[i]；
    // 在两种情况下取价值最大的结果，就是物品 i 装入背包或不装入背包的最大价值
    // 所以可以写出如下的暴力递归代码：
    int knapsack(int W, int N, int[] wt, int[] val) {
        assert N == wt.length;
        // base case 已初始化
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w - wt[i - 1] < 0) {
                    // 这种情况下只能选择不装入背包
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(
                        dp[i - 1][w - wt[i-1]] + val[i-1], 
                        dp[i - 1][w]
                    );
                }
            }
        }
        
        return dp[N][W];
    }
}
