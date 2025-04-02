package labuladong._0_核心框架汇总.动态规划解题套路框架.凑零钱问题;

import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/
public class _322_零钱兑换 {
    // 方法一：带备忘录的递归
    class Solution1 {
        int[] memo;

        public int coinChange(int[] coins, int amount) {
            memo = new int[amount + 1];
            // dp 数组全都初始化为特殊值
            Arrays.fill(memo, -666);
            return dp(coins, amount);
        }

        // 递归函数的定义：输入一个目标金额 amount，返回凑出目标金额所需的最少硬币数量
        int dp(int[] coins, int amount) {
            if (amount == 0)
                return 0;
            if (amount < 0)
                return -1;
            // 查备忘录，防止重复计算
            if (memo[amount] != -666)
                return memo[amount];
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1)
                    continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            // 把计算结果存入备忘录
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }

    // 方法二：自底向上的迭代解法
    class Solution2 {
        // dp数组的定义：
        int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），所以初始化为 amount + 1
            Arrays.fill(dp, amount + 1);

            // base case
            dp[0] = 0;
            // 外层 for 循环在遍历所有状态的所有取值
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    // 凑出 i 元的硬币，但是给出的硬币金额大于 i 元
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }
}
