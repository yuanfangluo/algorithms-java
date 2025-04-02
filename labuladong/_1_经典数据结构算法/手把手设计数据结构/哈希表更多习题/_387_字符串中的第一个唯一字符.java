package labuladong._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

// https://leetcode.cn/problems/first-unique-character-in-a-string/
public class _387_字符串中的第一个唯一字符 {

    class Solution1 {
        public int firstUniqChar(String s) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        public int firstUniqChar(String s) {
            int min = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                int firstIdx = s.indexOf(c);
                int lastIdx = s.lastIndexOf(c);
                if (firstIdx != -1 && firstIdx == lastIdx) {
                    min = Math.min(firstIdx, min);
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }
    }
}
