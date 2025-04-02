package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;

// https://leetcode.cn/problems/splitting-a-string-into-descending-consecutive-values/
public class _1849_将字符串拆分为递减的连续值 {
    // 站在字符的视角进行穷举
    // 对于 s 中每个字符间隙都有两种选择：「切割」或者「不切割」，如果切割，则产生一个新子串。
        class Solution1 {
        boolean found = false;

        public boolean splitString(String s) {
            backtrack(s, 0, 0);
            return found;
        }

        LinkedList<String> track = new LinkedList<>();

        // start 表示当前子串的起始位置
        // index 表示当前子串的结束位置
        // 注意：这里的 index 是指子串的结束位置
        // 所以，index 是 s.length() - 1 时，子串的结束位置就是 s.length() - 1
        void backtrack(String s, int start, int index) {
            if (found) {
                // 剪枝，找到一个答案后就不要再继续回溯了
                return;
            }

            if (index == s.length()) {
                if (track.size() >= 2 && String.join("", track).equals(s)) {
                    found = true;
                }
                return;
            }

            // 选择一，s[index] 决定切割
            String subStr = s.substring(start, index + 1);
            // 计算前面有多少个 0
            int leadingZeroCount = 0;
            for (int j = 0; j < subStr.length(); j++) {
                if (subStr.charAt(j) == '0') {
                    leadingZeroCount++;
                } else {
                    break;
                }
            }

            // 剪枝逻辑
            // 如果当前截取的子串长度大于 s 的一半，那么没必要继续截取了，肯定不可能只差一
            // 同时可以避免溢出 long 的最大值的问题
            if ((subStr.length() - leadingZeroCount) > (s.length() + 1) / 2) {
                return;
            }

            long curNum = Long.parseLong(subStr);

            // 如果track里面没有数字，或者当前数字比上一个数字小 1，那么就可以继续切割
            if (track.isEmpty() || Long.parseLong(track.getLast()) - curNum == 1) {
                // 符合题目的要求，当前数字比上一个数字小 1
                // 做选择，切割出一个子串
                track.add(subStr);
                // 继续回溯
                backtrack(s, index + 1, index + 1);
                // 撤销选择
                track.removeLast();
            }

            // 选择二，s[index] 决定不切割
            backtrack(s, start, index + 1);
        }
    }

    // 站在子串的视角进行穷举
    // 每个子串可以选择包含 s[start] 开头的任意个字符。
    class Solution2 {
        public boolean splitString(String s) {
            backtrack(s, 0);
            return found;
        }

        LinkedList<String> track = new LinkedList<>();
        boolean found = false;

        void backtrack(String s, int start) {
            if (found) {
                // 剪枝，找到一个答案后就不要再继续回溯了
                return;
            }

            if (start == s.length()) {
                if (track.size() >= 2 && String.join("", track).equals(s)) {
                    found = true;
                }
                return;
            }

            for (int i = start; i < s.length(); i++) {
                String subStr = s.substring(start, i + 1);
                int leadingZeroCount = 0;
                for (int j = 0; j < subStr.length(); j++) {
                    if (subStr.charAt(j) == '0') {
                        leadingZeroCount++;
                    } else {
                        break;
                    }
                }
                
                if (subStr.length() - leadingZeroCount > (s.length() + 1) / 2) {
                    // 剪枝逻辑，如果当前截取的子串长度大于 s 的一半，那么没必要继续截取了，肯定不可能只差一
                    // 同时可以避免溢出 long 的最大值的问题
                    return;
                }

                long curNum = Long.parseLong(subStr);
                if (track.isEmpty() || Long.parseLong(track.getLast()) - curNum == 1) {
                    // 符合题目的要求，当前数字比上一个数字小 1
                    // 做选择，切割出一个子串
                    track.add(subStr);
                    backtrack(s, i + 1);
                    // 撤销选择
                    track.removeLast();
                }
            }
        }
    }
}
