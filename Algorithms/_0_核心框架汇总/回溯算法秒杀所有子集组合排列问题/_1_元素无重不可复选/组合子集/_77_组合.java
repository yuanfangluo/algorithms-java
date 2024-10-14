package Algorithms._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._1_元素无重不可复选.组合子集;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/combinations/
* 返回范围 [1, n] 中所有可能的 k 个数的组合。
输入：n = 4, k = 2
返回范围 [1, 4] 中所有可能的 2 个数的组合。
输出：
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
// 通过 start 参数控制树枝的遍历，避免产生重复的子集
public class _77_组合 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(1, n, k);
            return res;
        }

        /*
         * start ：控制不重复
         * n ： 可选项
         * k ： 个数
         */
        void backtrack(int start, int n, int k) {
            // base case。结束条件
            if (k == track.size()) {
                // 遍历到了第 k 层，收集当前节点的值
                res.add(new LinkedList<>(track));
                return;
            }
            
            // 回溯算法标准框架
            for (int i = start; i <= n; i++) {
                // 选择
                track.addLast(i);
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(i + 1, n, k);
                // 撤销选择
                track.removeLast();
            }
        }
    }
}
