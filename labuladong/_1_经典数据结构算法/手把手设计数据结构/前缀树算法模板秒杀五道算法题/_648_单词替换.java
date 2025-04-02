package labuladong._1_经典数据结构算法.手把手设计数据结构.前缀树算法模板秒杀五道算法题;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.cn/problems/replace-words/
public class _648_单词替换 {
    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Set<String> dictionarySet = new HashSet<String>();
            for (String root : dictionary) {
                dictionarySet.add(root);
            }
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    if (dictionarySet.contains(word.substring(0, 1 + j))) {
                        words[i] = word.substring(0, 1 + j);
                        break;
                    }
                }
            }
            return String.join(" ", words);
        }
    }

    class Solution2 {
        // 考察最短前缀问题
        String replaceWords(List<String> dict, String sentence) {
            // 先将词根都存入 TrieSet
            TrieSet set = new TrieSet();
            for (String key : dict) {
                set.add(key);
            }
            StringBuilder sb = new StringBuilder();
            String[] words = sentence.split(" ");
            // 处理句子中的单词
            for (int i = 0; i < words.length; i++) {
                // 在 Trie 树中搜索最短词根（最短前缀）
                String prefix = set.shortestPrefixOf(words[i]);
                if (!prefix.isEmpty()) {
                    // 如果搜索到了，改写为词根
                    sb.append(prefix);
                } else {
                    // 否则，原样放回
                    sb.append(words[i]);
                }

                if (i != words.length - 1) {
                    // 添加单词之间的空格
                    sb.append(' ');
                }
            }

            return sb.toString();
        }
    }
}
