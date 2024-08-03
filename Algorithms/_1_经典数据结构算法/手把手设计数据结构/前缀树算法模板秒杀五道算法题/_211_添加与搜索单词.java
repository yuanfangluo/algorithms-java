package Algorithms._1_经典数据结构算法.手把手设计数据结构.前缀树算法模板秒杀五道算法题;

// https://leetcode.cn/problems/design-add-and-search-words-data-structure/
public class _211_添加与搜索单词 {

    

    class WordDictionary {
        TrieSet set = new TrieSet();
        
        // 在 TrieSet 中添加元素
        public void addWord(String word) {
            set.add(word);
        }
        
        // 通配符匹配元素
        public boolean search(String word) {
            return set.hasKeyWithPattern(word);
        }
    }
}
