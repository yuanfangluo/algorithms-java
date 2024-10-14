package Algorithms._0_核心框架汇总.回溯算法秒杀所有子集组合排列问题._1_元素无重不可复选.排列;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/permutations/
// 使用used数组来控制标记哪些元素可以被选
public class _46_全排列 {

    // 方法一
    class Solution1 {
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
        // 结束条件：nums 中的元素全都在 track 中出现
        void backtrack(int[] nums, LinkedList<Integer> track) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i])) {
                    // nums[i] 已经在 track 中，跳过
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择
                track.removeLast();
            }
        }
    }

    // 方法二：使用used数组优化 contains 方法
    class Solution2 {
        List<List<Integer>> res = new LinkedList<>();
        List<List<Integer>> permute2(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            // 「路径」中的元素会被标记为 true，避免重复使用
            boolean[] used = new boolean[nums.length];
            backtrack(nums, track, used);
            return res;
        }

        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素（used[i] 为 false）
        // 结束条件：nums 中的元素全都在 track 中出现
        void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (used[i]) {
                    // nums[i] 已经在 track 中，跳过
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                used[i] = true;
                // 进入下一层决策树
                backtrack(nums, track, used);
                // 取消选择
                track.removeLast();
                used[i] = false;
            }
        }
    }
}
