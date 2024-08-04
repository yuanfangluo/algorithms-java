package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class _17_电话号码的字母组合 {
    class Solution {
        // 每个数字到字母的映射
        String[] mapping = new String[] {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) {
                return res;
            }
            // 从 digits[0] 开始进行回溯
            backtrack(digits, 0);
            return res;
        }

        // 回溯算法主函数
        void backtrack(String digits, int start) {
            if (sb.length() == digits.length()) {
                // 到达回溯树底部
                res.add(sb.toString());
                return;
            }

            // 回溯算法框架
            int digit = digits.charAt(start) - '0';
            for (char c : mapping[digit].toCharArray()) {
                // 做选择
                sb.append(c);
                // 递归下一层回溯树
                backtrack(digits, start + 1);
                // 撤销选择
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
