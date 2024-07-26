package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/letter-case-permutation/
// 对于每一个字符，有如下选择：
// 1、如果该字符是字母，则可以是大写，也可以是小写。
// 2、如果该字符是数字，则只能是它本身。
public class _784_字母大小写全排列 {
    class Solution {
        List<String> res = new LinkedList<>();

        public List<String> letterCasePermutation(String s) {
            backtrack(s, 0);
            return res;
        }

        StringBuilder track = new StringBuilder();

        void backtrack(String s, int index) {
            if (index == s.length()) {
                res.add(track.toString());
                return;
            }

            if ('0' <= s.charAt(index) && s.charAt(index) <= '9') {
                // s[index] 是数字
                // 做选择
                track.append(s.charAt(index));
                backtrack(s, index + 1);
                // 撤销选择
                track.deleteCharAt(track.length() - 1);
            } else {
                // s[index] 是字母,可以是小写字母，也可以是大写字母

                // 小写字母，做选择
                track.append(Character.toLowerCase(s.charAt(index)));
                backtrack(s, index + 1);
                // 撤销选择
                track.deleteCharAt(track.length() - 1);

                // 大写字母，做选择
                track.append(Character.toUpperCase(s.charAt(index)));
                backtrack(s, index + 1);
                // 撤销选择
                track.deleteCharAt(track.length() - 1);
            }
        }
    }

}
