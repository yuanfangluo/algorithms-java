package Algorithms.其他常见算法技巧.经典面试题.如何解决括号相关的问题;

// https://leetcode.cn/problems/minimum-insertions-to-balance-a-parentheses-string/
public class _1541_平衡括号字符串的最少插入次数 {
    class Solution {
        public int minInsertions(String s) {
            int res = 0, need = 0;
            for (int i = 0; i < s.length(); i++) {
                // 当遇到左括号时
                if (s.charAt(i) == '(') {
                    // 一个左括号对应两个右括号
                    need += 2;
                    // 若对右括号的需求量为奇数，需要插入 1 个右括号
                    if (need % 2 == 1) {
                        res++;
                        need--;
                    }
                }
    
                if (s.charAt(i) == ')') {
                    need--;
                    // 当 need == -1 时，意味着我们遇到一个多余的右括号，显然需要插入一个左括号。
                    if (need == -1) {
                        res++;
                        // 但是由于一个左括号需要两个右括号，所以对右括号的需求量变为 1
                        need = 1;
                    }
                }
            }
            return res + need;
        }
    }
}
