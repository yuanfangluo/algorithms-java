package labuladong.手把手刷动态规划.动态规划基本技巧.动态规划穷举的两种视角;

import java.util.Arrays;

// https://leetcode.cn/problems/distinct-subsequences/
public class _115_不同的子序列 {
    // 回顾一下之前讲的排列组合的「球盒模型」，这里是不是很类似？
    // t 中的若干字符就好像若干盒子，s 中的若干字符就好像若干小球，你需要做的就是给所有盒子都装一个小球。
    // 所以这里就有两种穷举思路了，分别是站在 t 的视角（盒子选择小球）和站在 s 的视角（小球选择盒子）。

    // 视角一，站在 t 的角度进行穷举：
    class Solution1 {
        // 备忘录
        int[][] memo;

        int numDistinct(String s, String t) {
            // 初始化备忘录为特殊值 -1
            memo = new int[s.length()][t.length()];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s, 0, t, 0);
        }

        // 定义：s[i..] 的子序列中 t[j..] 出现的次数为 dp(s, i, t, j)
        int dp(String s, int i, String t, int j) {
            // base case 1
            if (j == t.length()) {
                return 1;
            }
            // base case 2
            if (s.length() - i < t.length() - j) {
                return 0;
            }
            // 查备忘录防止冗余计算
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int res = 0;
            // 执行状态转移方程
            // 在 s[i..] 中寻找 k，使得 s[k] == t[j]
            for (int k = i; k < s.length(); k++) {
                if (s.charAt(k) == t.charAt(j)) {
                    // 累加结果
                    res += dp(s, k + 1, t, j + 1);
                }
            }
            // 存入备忘录
            memo[i][j] = res;
            return res;
        }
    }

    // 视角二，站在 s 的角度进行穷举：
    class Solution2 {
        int[][] memo;

        int numDistinct(String s, String t) {
            // 初始化备忘录为特殊值 -1
            memo = new int[s.length()][t.length()];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dp(s, 0, t, 0);
        }

        // 定义：s[i..] 的子序列中 t[j..] 出现的次数为 dp(s, i, t, j)
        int dp(String s, int i, String t, int j) {
            // base case 1
            if (j == t.length()) {
                return 1;
            }
            // base case 2
            if (s.length() - i < t.length() - j) {
                return 0;
            }
            // 查备忘录防止冗余计算
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int res = 0;
            // 执行状态转移方程
            if (s.charAt(i) == t.charAt(j)) {
                // 匹配，两种情况，累加关系
                res = dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
            } else {
                // 不匹配，在 s[i+1..] 的子序列中计算 t[j..] 的出现次数
                res = dp(s, i + 1, t, j);
            }
            // 结果存入备忘录
            memo[i][j] = res;
            return res;
        }
    }

    class Solution {
        public int numDistinct(String s, String t) {
            int len1 = s.length(), len2 = t.length();
            if (len1 < len2) {
                return 0;
            }
            char[] cs = s.toCharArray();
            char[] ct = t.toCharArray();
            int[] dp = new int[len2 + 1];
            dp[0] = 1;
            for (int i = 1; i <= len1; i++) {
                char sCur = cs[i - 1];
                int start = Math.max(len2 - len1 + i, 1);
                for (int j = Math.min(i, len2); j >= start; j--) {
                    if (ct[j - 1] == sCur) {
                        dp[j] += dp[j - 1];
                    }
                }
            }
            return dp[len2];
        }
    }
}
