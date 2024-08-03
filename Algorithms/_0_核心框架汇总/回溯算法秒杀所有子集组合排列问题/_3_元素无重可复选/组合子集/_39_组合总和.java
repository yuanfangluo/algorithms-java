package Algorithms._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._3_元素无重可复选.组合子集;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum/
// candidates = [1,2,3], target = 3
// [ [1,1,1],[1,2],[3] ]

public class _39_组合总和 {
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯的路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录 track 中的路径和
        int trackSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            backtrack(candidates, 0, target);
            return res;
        }

        // 回溯算法主函数
        void backtrack(int[] nums, int start, int target) {
            // base case，找到目标和，记录结果
            if (trackSum == target) {
                res.add(new LinkedList<>(track));
                return;
            }
            // base case，超过目标和，停止向下遍历
            if (trackSum > target) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 选择 nums[i]
                trackSum += nums[i];
                track.add(nums[i]);
                // 递归遍历下一层回溯树
                // 同一元素可重复使用，注意参数
                backtrack(nums, i, target);
                // 撤销选择 nums[i]
                trackSum -= nums[i];
                track.removeLast();
            }
        }
    }
}
