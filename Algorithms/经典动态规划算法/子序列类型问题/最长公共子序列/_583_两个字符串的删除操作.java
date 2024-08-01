package Algorithms.经典动态规划算法.子序列类型问题.最长公共子序列;

// https://leetcode.cn/problems/delete-operation-for-two-strings/
public class _583_两个字符串的删除操作 {
    // 题目让我们计算将两个字符串变得相同的最少删除次数，那我们可以思考一下，最后这两个字符串会被删成什么样子？
    // 删除的结果不就是它俩的最长公共子序列嘛！
    class Solution {
        int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // 复用前文计算 lcs 长度的函数
            int lcs = longestCommonSubsequence(s1, s2);
            return m - lcs + n - lcs;
        }

        public int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            // 定义：s1[0..i-1] 和 s2[0..j-1] 的 lcs 长度为 dp[i][j]
            // 目标：s1[0..m-1] 和 s2[0..n-1] 的 lcs 长度，即 dp[m][n]
            // base case: dp[0][..] = dp[..][0] = 0

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 现在 i 和 j 从 1 开始，所以要减一
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        // s1[i-1] 和 s2[j-1] 必然在 lcs 中
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        // s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
