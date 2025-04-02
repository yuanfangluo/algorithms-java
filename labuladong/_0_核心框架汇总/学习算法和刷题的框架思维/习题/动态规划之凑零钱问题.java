package labuladong._0_核心框架汇总.学习算法和刷题的框架思维.习题;

public class 动态规划之凑零钱问题 {
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1)
                continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
