package labuladong._4_其他常见算法技巧.经典面试题.如何解决括号相关的问题;

// https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid/
public class _921_使括号有效的最少添加 {
    class Solution {
        public int minAddToMakeValid(String s) {
            // res 记录插入次数
            int res = 0;
            // need 变量记录右括号的需求量
            int need = 0;
    
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    // 对右括号的需求 + 1
                    need++;
                }
    
                if (s.charAt(i) == ')') {
                    // 对右括号的需求 - 1
                    need--;
    
                    if (need == -1) {
                        need = 0;
                        // 需插入一个左括号
                        res++;
                    }
                }
            }
    
            return res + need;
        }
    }
}
