package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法秒杀所有排列组合子集问题;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/subsets-ii/
* 
* */
public class _90_子集_II {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // 先排序，让相同的元素靠在一起
            // 如果发现 nums[i] == nums[i-1]，则跳过
            Arrays.sort(nums);
            backtrack(nums, 0);
            return res;
        }

        void backtrack(int[] nums, int start) {
            // 前序位置，每个节点的值都是一个子集
            res.add(new LinkedList<>(track));
            for (int i = start; i < nums.length; i++) {
                // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.addLast(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }
    }
}
