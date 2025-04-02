package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/numbers-with-same-consecutive-differences/
public class _967_连续差相同的数字 {
    // 元素无重可复选的排列

    // 相当于给你 n 个盒子，然后你有 0~9 种球（元素）可以放进盒子，每个盒子只能放一个球，但每种球的数量无限，可以使用无数次。
    
    // 不过这道题比标准的「元素无重可复选的排列」多了两个剪枝逻辑：
    // 1、第一个数字不能是 0，因为题目要求数字不能以 0 开头；
    // 2、相邻两个数字的差的绝对值必须等于 k。

    class Solution {
        List<Integer> res = new LinkedList<>();
        // 记录当前路径组成的数字的值
        int track = 0;
        // 记录当前数字的位数
        int digit = 0;

        public int[] numsSameConsecDiff(int n, int k) {
            backtrack(n, k);
            // Java 需要把 List<Integer> 转成 int[]
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        // n 表示数字的位数
        // k 表示相邻数字的差的绝对值
        void backtrack(int n, int k) {
            // base case，到达叶子节点
            if (digit == n) {
                // 找到一个合法的 n 位数
                res.add(track);
                return;
            }

            // 回溯算法标准框架
            for (int i = 0; i <= 9; i++) {
                // 本题的剪枝逻辑 1，第一个数字不能是 0
                if (digit == 0 && i == 0) {
                    continue;
                }

                // 本题的剪枝逻辑 2，相邻两个数字的差的绝对值必须等于 k，如果不等于k，就需要剪枝
                if (digit > 0 && Math.abs(i - track % 10) != k)
                    continue;

                // 做选择，在 track 尾部追加数字 i
                digit++;
                track = 10 * track + i;
                // 进入下一层回溯树
                backtrack(n, k);
                // 取消选择，删除 track 尾部数字
                track = track / 10;
                digit--;
            }
        }
    }

}
