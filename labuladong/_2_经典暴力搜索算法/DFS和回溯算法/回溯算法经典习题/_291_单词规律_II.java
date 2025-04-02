package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/word-pattern-ii/
public class _291_单词规律_II {
    // 回溯算法
    // 就从 pattern 的视角来穷举吧。
    // 其中的每个字符 pattern[i] 有多种选择，可以匹配 s 的前一个字符，或者前两个字符，或者前三个字符...

    class Solution {
        public boolean wordPatternMatch(String pattern, String s) {
            backtrack(pattern, 0, s);
            return res;
        }

        // 用来存储 pattern 中的字符映射 s 中的子字符串，比如 'a' -> "red"
        Map<Character, String> patternToWord = new HashMap<>();
        // 因为题目说双射，所以还需要一个 map 用来存储 s 中的子字符串映射 pattern 中的字符，
        // 比如 "red" -> 'a'，避免重复
        Map<String, Character> wordToPattern = new HashMap<>();
        // 记录是否已经找到了可行的映射
        boolean res = false;

        // 回溯算法模板，pattern[index] 做选择，穷举所有可能的映射关系
        void backtrack(String pattern, int index, String s) {
            if (res) {
                // 如果已经找到了可行的映射，就直接返回，不用再穷举了
                return;
            }

            if (index == pattern.length() && s.length() == 0) {
                // 如果 pattern 和 s 都遍历完了，说明找到了可行的映射
                res = true;
                return;
            }
            if (index == pattern.length() || s.length() == 0) {
                // 如果 pattern 和 s 只有一个遍历完了，但另一个还没遍历完
                // 说明不是可行的映射
                return;
            }

            char c = pattern.charAt(index);

            if (patternToWord.containsKey(c)) {
                // 如果 pattern 中的字符 c 已经有了映射
                String word = patternToWord.get(c);
                if (s.startsWith(word)) {
                    // 如果 s 的前缀是 word，就继续尝试用 pattern[index+1..]
                    // 去匹配 s[word.length()..]
                    backtrack(pattern, index + 1, s.substring(word.length()));
                } else {
                    // 如果 s 的前缀不是 word，说明不是可行的映射
                    return;
                }
            } else {
                // 如果 pattern 中的字符 c 还没有映射
                // 多叉树暴力穷举，c 可能映射到 s 的前 1 个字符，或者前 2 个字符...
                for (int i = 1; i <= s.length(); i++) {
                    String word = s.substring(0, i);
                    if (wordToPattern.containsKey(word)) {
                        // 如果 word 已经有了映射，就不能再用了
                        continue;
                    }
                    // 做选择，记录双射关系
                    patternToWord.put(c, word);
                    wordToPattern.put(word, c);
                    
                    // 继续穷举下一个字符
                    backtrack(pattern, index + 1, s.substring(i));

                    // 撤销选择，清除双射关系
                    wordToPattern.remove(word);
                    patternToWord.remove(c);
                }
            }
        }
    }
}
