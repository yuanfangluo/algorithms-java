package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.cn/problems/split-a-string-into-the-max-number-of-unique-substrings/
public class _1593_拆分字符串使唯一子字符串的数目最大 {
    class Solution {
        Set<String> set = new HashSet<>();
        int res = 0;

        public int maxUniqueSplit(String s) {
            backtrack(s, 0);
            return res;
        }

        void backtrack(String s, int index) {
            if (index == s.length()) {
                res = Math.max(res, set.size());
                return;
            }

            // 选择不切，什么都不做，直接走到下一个索引空隙
            backtrack(s, index + 1);
            // 选择切，把 s[0..index] 切分出来作为一个子串
            String sub = s.substring(0, index + 1);
            // 按照题目要求，不能有重复的子串
            if (!set.contains(sub)) {
                // 做选择
                set.add(sub);
                // 剩下的字符继续穷举
                backtrack(s.substring(index + 1), 0);
                // 撤销选择
                set.remove(sub);
            }
        }

    }
}
