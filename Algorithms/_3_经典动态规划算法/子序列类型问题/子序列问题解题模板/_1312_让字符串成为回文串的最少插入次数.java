package Algorithms._3_经典动态规划算法.子序列类型问题.子序列问题解题模板;

// https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class _1312_让字符串成为回文串的最少插入次数 {
    class Solution {
        int minInsertions(String s) {
            int n = s.length();
            // dp[i][j] 表示把字符串 s[i..j] 变成回文串的最少插入次数
            // dp 数组全部初始化为 0
            int[][] dp = new int[n][n];
            // 反着遍历保证正确的状态转移
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    // 状态转移方程
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
            // 整个 s 的最少插入次数
            return dp[0][n - 1];
        }
    }
}
