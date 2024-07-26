package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// https://leetcode.cn/problems/gray-code/

public class _89_格雷编码 {
    class Solution {
        public List<Integer> grayCode(int n) {
            traverse(0, n);
            return res;
        }
        
        // 表示已经取的数字
        Set<Integer> used = new HashSet<>();
        LinkedList<Integer> path = new LinkedList<>();
        List<Integer> res = null;

        void traverse(int root, int n) {
            if (res != null) {
                return;
            }

            if (path.size() == (1 << n)) {
                res = new LinkedList<>(path);
                return;
            }

            if (used.contains(root)) {
                return;
            }

            // 多叉树遍历的前序位置
            used.add(root);
            path.addLast(root);

            // 对当前数字的每个二进制位进行翻转，得到子节点
            for (int i = 0; i < n; i++) {
                int next = flipBit(root, i);
                traverse(next, n);
            }

            // 多叉树遍历的后序位置
            used.remove(root);
            path.pop();
        }

        // 把第 i 位取反（0 变 1，1 变 0）
        int flipBit(int x, int i) {
            return x ^ (1 << i);
        }
    }
}
