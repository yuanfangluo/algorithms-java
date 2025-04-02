package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/palindrome-partitioning/
public class _131_分割回文串 {
    // 回溯算法
    class Solution {
        List<List<String>> res = new LinkedList<>();
        LinkedList<String> track = new LinkedList<>();

        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return res;
        }
        
        // 回溯算法框架：
        // backtrack(路径, 选择列表)
        // 路径：track 中记录在 s 中已经走过的路径
        // 选择列表：s 中剩余的字符，即 s[start..] 中剩余的字符
        // 结束条件：当 start == s.length() 时，说明已经走到了 s 的末尾，找到了一个分割方案
        // 选择：在 s[start..] 中选择一个子串作为分割点，即 s[start..i] 作为一个分割点
        // 约束条件：s[start..i] 必须是一个回文串
        // 回溯：分割点选择列表中移除 s[start..i]，即回退到上一层的选择列表中
        // 时间复杂度：O(n * 2^n)，其中 n 是字符串 s 的长度
        // 空间复杂度：O(n)，其中 n 是字符串 s 的长度
        void backtrack(String s, int start) {
            if (start == s.length()) {
                // base case，走到叶子节点
                // 即整个 s 被成功分割为若干个回文子串，记下答案
                res.add(new ArrayList<String>(track));
                return;
            }

            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    // s[start..i] 不是回文串，不能分割
                    continue;
                }
                // s[start..i] 是一个回文串，可以进行分割

                // 做选择，把 s[start..i] 放入路径列表中
                track.addLast(s.substring(start, i + 1));

                // 进入回溯树的下一层，继续切分 s[i+1..]
                backtrack(s, i + 1);
                
                // 撤销选择
                track.removeLast();
            }
        }

        // 用双指针技巧判断 s[lo..hi] 是否是一个回文串
        boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
}
