package Algorithms._3_经典动态规划算法.玩游戏.正则表达式;

import java.util.Arrays;

// https://leetcode.cn/problems/regular-expression-matching/
public class _10_正则表达式匹配 {
    class Solution1 {
        // 两个字符串的穷举，考虑使用动态规划算法再加两个指针
        // 使用自顶向下的动态规划，所以使用备忘录来消除重叠子问题
        boolean[][] memo;

        public boolean isMatch(String s, String p) {
            int n = s.length();
            int m = p.length();
            memo = new boolean[n][m];
            for (boolean[] booleans : memo) {
                Arrays.fill(booleans, false);
            }
            return dp(s, 0, p, 0);
        }

        // 声明一下dp函数的定义：s[i..]和p[j..]能否匹配
        private boolean dp(String s, int i, String p, int j) {
            // base case
            // 1.如果我们p匹配到了最后一个字符，只需要判断此时的i是不是匹配到了s的最后一个字符，如果是的话就匹配成功了，如果不是的话就没有匹配成功
            if (j == p.length()) {
                return i == s.length();
            }
            // base case
            // 2.如果i匹配到了s的最后一个字符，此时我们还要判断j的一个位置，不能简单的判断j是不是匹配到了p的最后一个位置
            // 因为如果j后面的字符可以匹配一个空串的话也是可以匹配成功的
            if (i == s.length()) {
                // 如果能匹配空串的话，必须字符和*是成对出现的，因为*可以干掉前面的一个字符
                if ((p.length() - j) % 2 == 1) {
                    // 不是偶数
                    return false;
                }

                // 如果是偶数的话，我们还要判断是不是字符和*交替出现
                // ab*c*
                for (; j + 1 < p.length(); j += 2) {
                    // 如果不是字母和*交替出现直接返回false
                    if (p.charAt(j + 1) != '*') {
                        return false;
                    }
                }
                return true;
            }

            if (memo[i][j] != false) {
                return memo[i][j];
            }

            boolean res = false;
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                // 如果此时的位置上匹配上了
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    // 如果j后面一个字符是*，那么p[j]这个字符可以不匹配，或者匹配一个或者多个
                    res = dp(s, i + 1, p, j) || dp(s, i, p, j + 2);
                } else {
                    // 如果p[j]后面的字符不是*，那么只能老老实实的匹配一个了
                    res = dp(s, i + 1, p, j + 1);
                }
            } else {
                // 如果此时的位置不能匹配的话
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    // 如果此时p[j]后面的字符是*的话，只能不匹配
                    res = dp(s, i, p, j + 2);
                } else {
                    // 如果此时p[j]后面的字符不是*，直接就匹配失败了
                    return false;
                }
            }
            memo[i][j] = res;
            return res;
        }
    }

    class Solution2 {
        public boolean isMatch(String s, String p) {
            int m = s.length() + 1;
            int n = p.length() + 1;
            boolean[][] dp = new boolean[m][n];

            dp[0][0] = true;
            for (int i = 2; i < n; i += 2) {
                dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (p.charAt(j - 1) != '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (dp[i][j - 2]) {
                            dp[i][j] = dp[i][j - 2];
                        } else if (dp[i - 1][j] && (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.')) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
