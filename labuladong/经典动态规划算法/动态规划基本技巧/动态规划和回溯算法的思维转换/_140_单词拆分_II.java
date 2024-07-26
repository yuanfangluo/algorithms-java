package labuladong.经典动态规划算法.动态规划基本技巧.动态规划和回溯算法的思维转换;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/word-break-ii/
public class _140_单词拆分_II {
    // 分解问题
    class Solution1 {
        HashSet<String> wordDict;
        // 备忘录
        List<String>[] memo;

        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = new HashSet<>(wordDict);
            memo = new LinkedList[s.length()];
            return dp(s, 0);
        }

        // 定义：返回用 wordDict 构成 s[i..] 的所有可能
        List<String> dp(String s, int i) {
            List<String> res = new LinkedList<>();
            if (i == s.length()) {
                res.add("");
                return res;
            }
            // 防止冗余计算
            if (memo[i] != null) {
                return memo[i];
            }

            // 遍历 s[i..] 的所有前缀
            for (int len = 1; i + len <= s.length(); len++) {
                // 看看哪些前缀存在 wordDict 中
                String prefix = s.substring(i, i + len);
                if (wordDict.contains(prefix)) {
                    // 找到一个单词匹配 s[i..i+len)
                    List<String> subProblem = dp(s, i + len);
                    // 构成 s[i+len..] 的所有组合加上 prefix
                    // 就是构成构成 s[i] 的所有组合
                    for (String sub : subProblem) {
                        if (sub.isEmpty()) {
                            // 防止多余的空格
                            res.add(prefix);
                        } else {
                            res.add(prefix + " " + sub);
                        }
                    }
                }
            }
            // 存入备忘录
            memo[i] = res;
            return res;
        }
    }

    // 回溯算法
    // 这个解法的时间复杂度和前一道题类似，依然是 O(2^N * MN)，但由于这道题给的数据规模较小，所以可以通过所有测试用例。
    class Solution2 {
        // 记录结果
        List<String> res = new LinkedList<>();
        // 记录回溯算法的路径
        LinkedList<String> track = new LinkedList<>();
        List<String> wordDict;

        // 主函数
        public List<String> wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            // 执行回溯算法穷举所有可能的组合
            backtrack(s, 0);
            return res;
        }

        // 回溯算法框架
        void backtrack(String s, int i) {
            // base case
            if (i == s.length()) {
                // 找到一个合法组合拼出整个 s，转化成字符串
                res.add(String.join(" ", track));
                return;
            }

            // 回溯算法框架
            for (String word : wordDict) {
                // 看看哪个单词能够匹配 s[i..] 的前缀
                int len = word.length();
                if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                    // 找到一个单词匹配 s[i..i+len)
                    // 做选择
                    track.addLast(word);
                    // 进入回溯树的下一层，继续匹配 s[i+len..]
                    backtrack(s, i + len);
                    // 撤销选择
                    track.removeLast();
                }
            }
        }
    }
}
