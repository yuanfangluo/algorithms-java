package labuladong._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

// https://leetcode.cn/problems/valid-anagram/
public class _242_有效的字母异位词 {
    // 若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] count1 = encode(s);
            int[] count2 = encode(t);
            // 确保两个字符串中所有字符出现的数量相同
            for (int i = 0; i < count1.length; i++) {
                if (count1[i] != count2[i]) {
                    return false;
                }
            }
    
            return true;
        }
    
        // 计算字符的出现次数
        int[] encode(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                int delta = c - 'a';
                count[delta]++;
            }
            return count;
        }
    }
}
