package Algorithms._3_经典动态规划算法.动态规划基本技巧.动态规划和回溯算法的思维转换;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/word-break/
public class _139_单词拆分 {
    // 动态规划
    class Solution1 {
        // 用哈希集合方便快速判断是否存在
        HashSet<String> wordDict;
        // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
        int[] memo;

        // 主函数
        public boolean wordBreak(String s, List<String> wordDict) {
            // 转化为哈希集合，快速判断元素是否存在
            this.wordDict = new HashSet<>(wordDict);
            // 备忘录初始化为 -1
            this.memo = new int[s.length()];
            Arrays.fill(memo, -1);
            return dp(s, 0);
        }

        // 定义：s[i..] 是否能够被拼出
        boolean dp(String s, int i) {
            // base case
            if (i == s.length()) {
                return true;
            }
            // 防止冗余计算
            if (memo[i] != -1) {
                // 0 代表无法凑出，1 代表可以凑出
                return memo[i] == 0 ? false : true;
            }

            // 遍历 s[i..] 的所有前缀
            for (int len = 1; i + len <= s.length(); len++) {
                // 看看哪些前缀存在 wordDict 中
                String prefix = s.substring(i, i + len);
                if (wordDict.contains(prefix)) {
                    // 找到一个单词匹配 s[i..i+len)
                    // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                    boolean subProblem = dp(s, i + len);
                    if (subProblem == true) {
                        memo[i] = 1;
                        return true;
                    }
                }
            }
            // s[i..] 无法被拼出
            memo[i] = 0;
            return false;
        }
    }

    // 回溯算法，时间复杂度高
    class Solution2 {
        List<String> wordDict;
        // 记录是否找到一个合法的答案
        boolean found = false;
        // 记录回溯算法的路径
        LinkedList<String> track = new LinkedList<>();

        // 主函数
        public boolean wordBreak(String s, List<String> wordDict) {
            this.wordDict = wordDict;
            // 执行回溯算法穷举所有可能的组合
            backtrack(s, 0);
            return found;
        }

        // 回溯算法框架
        // s 表示原始字符串，i 表示原始字符串的位置
        void backtrack(String s, int i) {
            // base case
            if (found) {
                // 如果已经找到答案，就不要再递归搜索了
                return;
            }

            if (i == s.length()) {
                // 整个 s 都被匹配完成，找到一个合法答案
                found = true;
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
