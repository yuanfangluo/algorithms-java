package Algorithms._0_核心框架汇总.动态规划解题套路框架.斐波那契数列;

// https://leetcode.cn/problems/fibonacci-number/
public class _509_斐波那契数 {

    // 递归
    // 时间复杂度：O(2^N)
    class Solution1 {
        int fib(int N) {
            if (N == 1 || N == 2)
                return 1;
            return fib(N - 1) + fib(N - 2);
        }
    }

    // 带备忘录的递归解法
    // 时间复杂度：O(N)
    class Solution2 {
        int fib(int N) {
            // 备忘录全初始化为 0
            int[] memo = new int[N + 1];
            // 进行带备忘录的递归
            return dp(memo, N);
        }

        // 带着备忘录进行递归
        int dp(int[] memo, int n) {
            // base case
            if (n == 0 || n == 1)
                return n;
            // 已经计算过，不用再计算了
            if (memo[n] != 0)
                return memo[n];
            memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
            return memo[n];
        }
    }

    // 自底向上的迭代解法
    class Solution3 {
        int fib(int N) {
            if (N == 0)
                return 0;
            int[] dp = new int[N + 1];
            // base case
            dp[0] = 0;
            dp[1] = 1;
            // 状态转移
            for (int i = 2; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[N];
        }
    }

    // 可以进一步优化，把空间复杂度降为 O(1)
    class Solution4 {
        public int fib(int n) {
            if (n == 0 || n == 1) {
                // base case
                return n;
            }
            // 分别代表 dp[i - 1] 和 dp[i - 2]
            int dp_i_1 = 1, dp_i_2 = 0;
            for (int i = 2; i <= n; i++) {
                // dp[i] = dp[i - 1] + dp[i - 2];
                int dp_i = dp_i_1 + dp_i_2;
                dp_i_2 = dp_i_1;
                dp_i_1 = dp_i;
            }
            return dp_i_1;
        }
    }
}
