package Algorithms.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/sort-characters-by-frequency/
public class _451_根据字符出现频率排序 {
    class Solution {
        public String frequencySort(String s) {
            char[] chars = s.toCharArray();
            // s 中的字符 -> 该字符出现的频率
            HashMap<Character, Integer> charToFreq = new HashMap<>();
            for (char ch : chars) {
                charToFreq.put(ch, charToFreq.getOrDefault(ch, 0) + 1);
            }

            PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((entry1, entry2) -> {
                // 队列按照键值对中的值（字符出现频率）从大到小排序
                return entry2.getValue().compareTo(entry1.getValue());
            });

            // 按照字符频率排序
            for (Map.Entry<Character, Integer> entry : charToFreq.entrySet()) {
                pq.offer(entry);
            }

            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                // 把频率最高的字符排在前面
                Map.Entry<Character, Integer> entry = pq.poll();
                String part = String.valueOf(entry.getKey()).repeat(entry.getValue());
                sb.append(part);
            }

            return sb.toString();
        }
    }
}
