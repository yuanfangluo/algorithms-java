package labuladong._2_经典暴力搜索算法.DFS和回溯算法.括号生成;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/generate-parentheses/
public class _22_括号生成 {
    // 1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
    // 2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p)
    // 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。

    // 对于 2n 个位置，必然有 n 个左括号，n 个右括号，所以我们不是简单的记录穷举位置 i，
    // 而是用 left 记录还可以使用多少个左括号，用 right 记录还可以使用多少个右括号
    class Solution1 {
        // 回溯过程中的路径
        StringBuilder track = new StringBuilder();
        // 记录所有合法的括号组合
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n == 0)
                return res;
            // 可用的左括号和右括号数量初始化为 n
            backtrack(n, n);
            return res;
        }

        // 可用的左括号数量为 left 个，可用的右括号数量为 right 个
        private void backtrack(int left, int right) {
            // 若左括号剩下的多，说明不合法
            if (right < left) {
                return;
            }
            // 数量小于 0 肯定是不合法的
            if (left < 0 || right < 0) {
                return;
            }
            // 当所有括号都恰好用完时，得到一个合法的括号组合
            if (left == 0 && right == 0) {
                res.add(track.toString());
                return;
            }

            // 做选择，尝试放一个左括号
            track.append('(');
            backtrack(left - 1, right);
            // 撤消选择
            track.deleteCharAt(track.length() - 1);

            // 做选择，尝试放一个右括号
            track.append(')');
            backtrack(left, right - 1);
            // 撤销选择
            track.deleteCharAt(track.length() - 1);
        }
    }

    class Solution2 {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            if (n < 0)
                return list;
            dfs(0, n, n, new char[n << 1], list);
            return list;
        }

        /**
         *
         * @param idx         搜索的层号
         * @param leftRemain  左括号的剩余数量
         * @param rightRemain 右括号的剩余数量
         * @param string      用来存放每一层的选择
         */
        private void dfs(int idx, int leftRemain, int rightRemain, char[] string, List<String> list) {
            if (idx == string.length) {
                list.add(new String(string));
                return;
            }

            // 枚举这一层所有可能的选择
            // 选择一种可能之后，进入下一层搜索

            // 什么情况可以选择左括号？左括号的数量 > 0
            // 选择左括号，然后进入下一层搜索
            if (leftRemain > 0) {
                string[idx] = '(';
                dfs(idx + 1, leftRemain - 1, rightRemain, string, list);
            }

            // 当左括号、右括号的数量一样时，只能选择左括号
            // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
            // 选择右括号，然后进入下一层搜索
            if (rightRemain > 0 && leftRemain != rightRemain) {
                string[idx] = ')';
                dfs(idx + 1, leftRemain, rightRemain - 1, string, list);
            }
        }
    }

}
