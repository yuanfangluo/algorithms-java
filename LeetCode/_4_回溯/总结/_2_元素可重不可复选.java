package LeetCode._4_回溯.总结;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _2_元素可重不可复选 {
    // nums 中的元素可以存在重复，每个元素最多只能被使用一次，其关键在于排序和剪枝
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> sum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backtrack(candidates, 0);
        return res;
    }

    /* 组合/子集问题回溯算法框架 */
    void backtrack(int[] nums, int start) {
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，跳过值相同的相邻树枝
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            // 注意参数
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    /* 排列问题回溯算法框架 */
    boolean[] used;
    void backtrack(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 剪枝逻辑
            if (used[i]) {
                continue;
            }
            // 剪枝逻辑，固定相同的元素在排列中的相对位置
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            // 做选择
            used[i] = true;
            track.addLast(nums[i]);

            backtrack(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }



}
