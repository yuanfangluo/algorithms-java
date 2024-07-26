package labuladong.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/non-decreasing-subsequences/
public class _491_非递减子序列 {
    // 元素可重不可复选
    // 只不过这里又有一个额外的条件：
    // 组合中所有元素都必须是递增顺序。我们只需要添加一个 track.getLast() > nums[i] 条件即可。

    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            if (nums.length == 0) {
                return res;
            }
            backtrack(nums, 0);
            return res;
        }

        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        // start 用来记录本层递归的中，集合从哪里开始遍历
        void backtrack(int[] nums, int start) {
            if (track.size() >= 2) {
                // 找到一个合法答案
                res.add(new LinkedList<>(track));
            }
            // 用哈希集合防止重复选择相同元素
            HashSet<Integer> used = new HashSet<>();
            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 保证集合中元素都是递增顺序
                if (!track.isEmpty() && track.getLast() > nums[i]) {
                    continue;
                }
                // 保证不要重复使用相同的元素
                if (used.contains(nums[i])) {
                    continue;
                }
                
                // 做选择
                used.add(nums[i]);
                track.addLast(nums[i]);
                // 递归遍历下一层回溯树
                backtrack(nums, i + 1);
                // 撤销选择 nums[i]
                track.removeLast();
            }
        }
    }

}
