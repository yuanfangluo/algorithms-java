package Algorithms.经典数据结构算法.手把手设计数据结构.前缀树算法模板秒杀五道算法题;

import java.util.List;

// https://leetcode.cn/problems/map-sum-pairs/
public class _677_键值映射 {
    class MapSum {
        // 封装我们实现的 TrieMap
        TrieMap<Integer> map = new TrieMap<>();

        // 插入键值对
        public void insert(String key, int val) {
            map.put(key, val);
        }

        // 累加所有前缀为 prefix 的键的值
        public int sum(String prefix) {
            List<String> keys = map.keysWithPrefix(prefix);
            int res = 0;
            for (String key : keys) {
                res += map.get(key);
            }
            return res;
        }
    }
}
