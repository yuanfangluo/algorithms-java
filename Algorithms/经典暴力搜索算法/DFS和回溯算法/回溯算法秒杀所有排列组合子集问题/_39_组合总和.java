package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法秒杀所有排列组合子集问题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/
// candidates = [1,2,3], target = 3
// [ [1,1,1],[1,2],[3] ]

public class _39_组合总和 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            backtrack(candidates, 0, target, 0);
            return res;
        }

        void backtrack(int[] candidates, int start, int target, int sum) {
            // base case
            if (sum == target) {
                // 找到目标和
                res.add(new LinkedList<>(track));
                return;
            }

            if (sum > target) {
                // 超过目标和，直接结束
                return;
            }

            // 回溯算法框架
            for (int i = start; i < candidates.length; i++) {
                // 选择
                track.add(candidates[i]);
                sum += candidates[i];
                // 递归遍历下一层回溯树
                // 同一元素可重复使用，注意参数
                backtrack(candidates, i, target, sum);
                // 撤销选择 candidates[i]
                sum -= candidates[i];
                track.removeLast();
            }
        }
    }
}
