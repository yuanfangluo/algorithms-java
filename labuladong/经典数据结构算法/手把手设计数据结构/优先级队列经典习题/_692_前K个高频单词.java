package labuladong.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/top-k-frequent-words/
public class _692_前K个高频单词 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            // 字符串 -> 该字符串出现的频率
            HashMap<String, Integer> wordToFreq = new HashMap<>();
            for (String word : words) {
                wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                    (entry1, entry2) -> {
                        if (entry1.getValue().equals(entry2.getValue())) {
                            // 如果出现频率相同，按照字符串字典序排序
                            return entry2.getKey().compareTo(entry1.getKey());
                        }
                        // 队列按照字符串出现频率从小到大排序
                        return entry1.getValue().compareTo(entry2.getValue());
                    });

            // 按照字符串频率升序排序
            for (Map.Entry<String, Integer> entry : wordToFreq.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    // 维护出现频率最多的 k 个单词
                    pq.poll();
                }
            }

            // 把出现次数最多的 k 个字符串返回
            LinkedList<String> res = new LinkedList<>();
            while (!pq.isEmpty()) {
                res.addFirst(pq.poll().getKey());
            }
            return res;
        }
    }
}
