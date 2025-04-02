package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;

// https://leetcode.cn/problems/beautiful-arrangement/
public class _526_优美的排列 {
    class Solution {
        int res = 0;
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;

        public int countArrangement(int n) {
            used = new boolean[n + 1];
            backtrack(n, 1);
            return res;
        }

        // 回溯算法标准框架，站在索引的视角选择元素
        void backtrack(int n, int index) {
            // base case，到达叶子节点
            if (index > n) {
                // 找到一个结果
                res += 1;
                return;
            }

            // 索引 index 开始选择元素
            for (int elem = 1; elem <= n; elem++) {
                // 已经被其他索引选过的元素，不能重复选择
                if (used[elem]) {
                    continue;
                }
                if (!(index % elem == 0 || elem % index == 0)) {
                    continue;
                }
                // 做选择，index 选择元素 elem
                used[elem] = true;
                track.addLast(elem);
                // 进入下一层回溯树
                backtrack(n, index + 1);
                // 取消选择
                track.removeLast();
                used[elem] = false;
            }
        }
    }
}
