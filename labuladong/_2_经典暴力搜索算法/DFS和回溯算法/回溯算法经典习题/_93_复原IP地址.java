package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/restore-ip-addresses/
// s = "25525511135"
// ["255.255.11.135","255.255.111.35"]
// 首先要想到使用回溯算法，其次是怎么判断是否是合法的 ip 数字
public class _93_复原IP地址 {
    class Solution {
        List<String> res = new LinkedList<>();
        LinkedList<String> track = new LinkedList<>();

        public List<String> restoreIpAddresses(String s) {
            backtrack(s, 0);
            return res;
        }

        // 回溯算法框架
        void backtrack(String s, int start) {
            if (start == s.length() && track.size() == 4) {
                // base case，走到叶子节点
                // 即整个 s 被成功分割为合法的四部分，记下答案
                res.add(String.join(".", track));
            }

            for (int i = start; i < s.length(); i++) {
                if (!isValid(s, start, i)) {
                    // s[start..i] 不是合法的 ip 数字，不能分割
                    continue;
                }

                if (track.size() >= 4) {
                    // 已经分解成 4 部分了，不能再分解了
                    break;
                }

                // s[start..i] 是一个合法的 ip 数字，可以进行分割
                // 做选择，把 s[start..i] 放入路径列表中
                track.addLast(s.substring(start, i + 1));
                // 进入回溯树的下一层，继续切分 s[i+1..]
                backtrack(s, i + 1);
                // 撤销选择
                track.removeLast();
            }
        }

        // 判断 s[start..end] 是否是一个合法的 ip 数字
        boolean isValid(String s, int start, int end) {
            // 计算长度
            int length = end - start + 1;

            if (length == 0 || length > 3) {
                return false;
            }

            // 如果只有一位数字，肯定是合法的
            if (length == 1) {
                return true;
            }

            // 到这里代表多于一位数字，
            // 但开头是 0，肯定不合法
            if (s.charAt(start) == '0') {
                return false;
            }

            // 到这里排除了开头是 0 的情况，
            // 那么如果是两位数，怎么着都是合法的
            if (length <= 2) {
                return true;
            }

            // 到这里代表现在输入的一定是三位数
            if (Integer.parseInt(s.substring(start, start + length)) > 255) {
                // 不可能大于 255
                return false;
            } else {
                return true;
            }

        }
    }
}
