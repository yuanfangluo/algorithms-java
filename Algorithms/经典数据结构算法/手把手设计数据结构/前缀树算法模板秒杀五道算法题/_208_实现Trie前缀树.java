package Algorithms.经典数据结构算法.手把手设计数据结构.前缀树算法模板秒杀五道算法题;

// https://leetcode.cn/problems/implement-trie-prefix-tree/
public class _208_实现Trie前缀树 {
    class Trie {
        // 直接封装 TrieSet
        TrieSet set = new TrieSet();

        // 插入一个元素
        public void insert(String word) {
            set.add(word);
        }

        // 判断元素是否在集合中
        public boolean search(String word) {
            return set.contains(word);
        }

        // 判断集合中是否有前缀为 prefix 的元素
        public boolean startsWith(String prefix) {
            return set.hasKeyWithPrefix(prefix);
        }
    }
}
