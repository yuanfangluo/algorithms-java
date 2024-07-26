package labuladong.经典动态规划算法.子序列类型问题.最长公共子序列;

import java.util.Arrays;

// https://leetcode.cn/problems/longest-common-subsequence/
public class _1143_最长公共子序列 {
    // 用的是自顶向下带备忘录的动态规划思路
    class Solution1 {
        // 备忘录，消除重叠子问题
        int[][] memo;

        /* 主函数 */
        public int longestCommonSubsequence(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // 备忘录值为 -1 代表未曾计算
            memo = new int[m][n];
            for (int[] row : memo)
                Arrays.fill(row, -1);
            // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
            return dp(s1, 0, s2, 0);
        }

        // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
        int dp(String s1, int i, String s2, int j) {
            // base case
            if (i == s1.length() || j == s2.length()) {
                return 0;
            }
            // 如果之前计算过，则直接返回备忘录中的答案
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            // 根据 s1[i] 和 s2[j] 的情况做选择
            if (s1.charAt(i) == s2.charAt(j)) {
                // s1[i] 和 s2[j] 必然在 lcs 中
                memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
            } else {
                // s1[i] 和 s2[j] 至少有一个不在 lcs 中
                memo[i][j] = Math.max(
                        dp(s1, i + 1, s2, j),
                        dp(s1, i, s2, j + 1));
            }
            return memo[i][j];
        }
    }

    // 使用自底向上的迭代的动态规划思路
    class Solution2 {
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

    // 空间压缩技巧
    class Solution3 {
        public int longestCommonSubsequence(String text1, String text2) {
            if (text1 == null || text2 == null)
                return 0;
            char[] chars1 = text1.toCharArray();
            if (chars1.length == 0)
                return 0;
            char[] chars2 = text2.toCharArray();
            if (chars2.length == 0)
                return 0;
            return longestCommonSubsequence(chars1, chars2);
        }

        public int longestCommonSubsequence(char[] chars1, char[] chars2) {
            char[] rowsChars = chars1, colsChars = chars2;
            if (chars1.length < chars2.length) {
                colsChars = chars1;
                rowsChars = chars2;
            }

            int[] dp = new int[colsChars.length + 1];
            for (int i = 1; i <= rowsChars.length; i++) {
                int cur = 0;
                for (int j = 1; j <= colsChars.length; j++) {
                    int leftTop = cur;
                    cur = dp[j];
                    if (rowsChars[i - 1] == colsChars[j - 1]) {
                        dp[j] = leftTop + 1;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                }
            }
            return dp[colsChars.length];
        }
    }
}
