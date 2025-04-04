package labuladong._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._2_元素可重不可复选.组合子集;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/combination-sum-ii/
// 先排序，让相同的元素靠在一起
public class _40_组合总和_II {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            // 先排序，让相同的元素靠在一起
            Arrays.sort(candidates);
            backtrack(candidates, 0, target);
            return res;
        }

        // 回溯算法主函数
        void backtrack(int[] nums, int start, int target) {
            // base case，达到目标和，找到符合条件的组合
            if (trackSum == target) {
                res.add(new LinkedList<>(track));
                return;
            }

            // base case，超过目标和，直接结束
            if (trackSum > target) {
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 剪枝逻辑，值相同的树枝，只遍历第一条
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                trackSum += nums[i];
                // 递归遍历下一层回溯树
                backtrack(nums, i + 1, target);
                // 撤销选择
                track.removeLast();
                trackSum -= nums[i];
            }
        }
    }
}
