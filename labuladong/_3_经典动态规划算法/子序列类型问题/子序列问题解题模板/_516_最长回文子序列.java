package labuladong._3_经典动态规划算法.子序列类型问题.子序列问题解题模板;

// https://leetcode.cn/problems/longest-palindromic-subsequence/
public class _516_最长回文子序列 {
    class Solution {
        int longestPalindromeSubseq(String s) {
            int n = s.length();
            // dp 数组全部初始化为 0
            int[][] dp = new int[n][n];
            // base case
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            
            // 反着遍历保证正确的状态转移
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    // 状态转移方程
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            // 整个 s 的最长回文子串长度
            return dp[0][n - 1];
        }
    }
}
