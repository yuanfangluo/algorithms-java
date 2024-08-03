package Algorithms._1_经典数据结构算法.手把手设计数据结构.前缀树算法模板秒杀五道算法题;

// https://leetcode.cn/problems/implement-trie-ii-prefix-tree/
public class _1804_实现Trie_II {
    class Trie {
        // 封装我们实现的 TrieMap
        TrieMap<Integer> map = new TrieMap<>();

        // 插入 word 并记录插入次数
        public void insert(String word) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        // 查询 word 插入的次数
        public int countWordsEqualTo(String word) {
            if (!map.containsKey(word)) {
                return 0;
            }
            return map.get(word);
        }

        // 累加前缀为 prefix 的键的插入次数总和
        public int countWordsStartingWith(String prefix) {
            int res = 0;
            for (String key : map.keysWithPrefix(prefix)) {
                res += map.get(key);
            }
            return res;
        }

        // word 的插入次数减一
        public void erase(String word) {
            int freq = map.get(word);
            if (freq - 1 == 0) {
                map.remove(word);
            } else {
                map.put(word, freq - 1);
            }
        }
    }
}
