package Algorithms.核心框架汇总.算法的本质.二叉树;

public class 动态规划之凑零钱问题 {
    // 定义：输入金额 amount，返回凑出 amount 的最少硬币个数
    int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 递归计算凑出 amount - coin 的最少硬币个数
            int subProblem = coinChange(coins, amount - coin);
            if (subProblem == -1)
                continue;
            // 凑出 amount 的最少硬币个数
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
