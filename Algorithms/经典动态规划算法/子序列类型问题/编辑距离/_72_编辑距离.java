package Algorithms.经典动态规划算法.子序列类型问题.编辑距离;

// https://leetcode.cn/problems/edit-distance/
public class _72_编辑距离 {
    class Solution {
        public int minDistance(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            // 定义 dp[i][j] 是存储 s1[0...i-1] 变成 s2[0..j-1] 是最小编辑距离
            int[][] dp = new int[m + 1][n + 1];
            // base case
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            // 自底向上求解
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1]; // 什么都不做
                    } else {
                        dp[i][j] = min(
                                dp[i][j - 1] + 1, // 插入, 给 s1[i] 前面 插入一个和 s2[j] 一样的字符
                                dp[i - 1][j] + 1, // 删除，删除 s1[i]
                                dp[i - 1][j - 1] + 1 // 替换，将 s1[i] 替换成 s2[j]

                        );
                    }
                }
            }
            // 储存着整个 s1 和 s2 的最小编辑距离
            return dp[m][n];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }
    }
}
