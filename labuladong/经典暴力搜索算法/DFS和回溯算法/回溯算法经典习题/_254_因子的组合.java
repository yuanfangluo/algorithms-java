package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/factor-combinations/
public class _254_因子的组合 {
    // 分解问题的思路
    class Solution {
        public List<List<Integer>> getFactors(int n) {
            // 因子的组合
            // 分解问题的思路
            // 因子必须大于 1 并且小于 n
            return solveSubProblem(n, 2);
        }

        public List<List<Integer>> solveSubProblem(int n, int start) {
            List<List<Integer>> res = new ArrayList<>();
            if (n <= 3) {
                // base case，当 n <= 3 时，不再进行分解
                return res;
            }

            for (int x = start; x <= (int) Math.sqrt(n); x++) {
                // 剪枝
                if (n % x != 0) {
                    continue;
                }

                // x * n/x 这对儿因子是一定要加进去的
                res.add(new ArrayList<>(Arrays.asList(x, n / x)));

                // 然后，去递归求解子问题 n/x 的所有因子组合，注意控制算法跳过小于 x 的因子，避免结果重复
                List<List<Integer>> subResult = solveSubProblem(n / x, x);

                // 把 x 和子问题的因子凑起来，就是构成 n 的因子了
                for (List<Integer> list : subResult) {
                    list.add(x);
                    res.add(list);
                }
            }
            return res;
        }
    }
}
