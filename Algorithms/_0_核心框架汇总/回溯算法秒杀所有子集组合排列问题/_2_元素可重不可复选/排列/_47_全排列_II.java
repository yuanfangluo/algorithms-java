package Algorithms._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._2_元素可重不可复选.排列;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/permutations-ii/
// 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
public class _47_全排列_II {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            // 先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 原来的剪枝
                if (used[i]) {
                    continue;
                }
                // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    // 如果前面的相邻相等元素没有用过，则跳过
                    continue;
                }
                // 选择
                track.add(nums[i]);
                used[i] = true;
                // 进入下一层决策树
                backtrack(nums);
                // 撤销选择
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
