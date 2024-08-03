package Algorithms._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/remove-invalid-parentheses/
public class _301_删除无效的括号 {
    class Solution1 {

        List<String> res = new LinkedList<>();
        StringBuilder track = new StringBuilder();

        public List<String> removeInvalidParentheses(String s) {
            backtrack(s, 0);
            // 筛选出最长的有效括号字符串
            int maxLen = 0;
            for (String str : res) {
                maxLen = Math.max(maxLen, str.length());
            }
            HashSet<String> set = new HashSet<>();
            for (String str : res) {
                if (str.length() == maxLen) {
                    set.add(str);
                }
            }
            return new LinkedList<>(set);
        }

        // 回溯算法框架，穷举所有可能的有效括号
        void backtrack(String s, int i) {
            if (i == s.length()) {
                if (isValid(track.toString())) {
                    res.add(track.toString());
                }
                return;
            }
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                // 英文字母，必然不会被删除，所以直接加入 track
                track.append(c);
                backtrack(s, i + 1);
                track.deleteCharAt(track.length() - 1);
            } else {
                // 括号，有两种情况，要么保留，要么删除
                // 先看第一种情况，保留当前括号，加入 track
                // 做选择
                track.append(c);
                backtrack(s, i + 1);
                // 撤销选择
                track.deleteCharAt(track.length() - 1);

                // 再看第二种情况，删除当前括号
                // 不用加入 track，也就没有做选择撤销选择的过程
                backtrack(s, i + 1);
            }
        }

        // 判断括号字符串是否有效
        boolean isValid(String s) {
            int left = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    left++;
                } else if (c == ')') {
                    left--;
                    if (left < 0) {
                        // 右括号比左括号多，肯定无效
                        return false;
                    }
                }
            }
            // 如果左括号的数量等于右括号的数量，才是一个有效的括号字符串
            return left == 0;
        }
    }

    class Solution2 {
        private List<String> res = new ArrayList<String>();

        public List<String> removeInvalidParentheses(String s) {
            int lremove = 0;
            int rremove = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    lremove++;
                } else if (s.charAt(i) == ')') {
                    if (lremove == 0) {
                        rremove++;
                    } else {
                        lremove--;
                    }
                }
            }
            helper(s, 0, lremove, rremove);

            return res;
        }

        private void helper(String str, int start, int lremove, int rremove) {
            if (lremove == 0 && rremove == 0) {
                if (isValid(str)) {
                    res.add(str);
                }
                return;
            }

            for (int i = start; i < str.length(); i++) {
                if (i != start && str.charAt(i) == str.charAt(i - 1)) {
                    continue;
                }
                // 如果剩余的字符无法满足去掉的数量要求，直接返回
                if (lremove + rremove > str.length() - i) {
                    return;
                }
                // 尝试去掉一个左括号
                if (lremove > 0 && str.charAt(i) == '(') {
                    helper(str.substring(0, i) + str.substring(i + 1), i, lremove - 1, rremove);
                }
                // 尝试去掉一个右括号
                if (rremove > 0 && str.charAt(i) == ')') {
                    helper(str.substring(0, i) + str.substring(i + 1), i, lremove, rremove - 1);
                }
            }
        }

        private boolean isValid(String str) {
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    cnt++;
                } else if (str.charAt(i) == ')') {
                    cnt--;
                    if (cnt < 0) {
                        return false;
                    }
                }
            }

            return cnt == 0;
        }
    }
}
