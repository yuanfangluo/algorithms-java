package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法秒杀所有排列组合子集问题;

import java.util.LinkedList;
import java.util.List;

/*
* https://leetcode.cn/problems/subsets/
*
* 输入：nums = [1,2,3]
* 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class _78_子集 {
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            backtrack(nums, 0);
            return res;
        }

        void backtrack(int[] nums, int start) {
            // 前序位置，每个节点的值都是一个子集
            res.add(new LinkedList<>(track));
            // 回溯算法标准框架
            for (int i = start; i < nums.length; i++) {
                // 1.做选择
                track.addLast(nums[i]);
                // 2. 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(nums, i + 1);
                // 3. 撤销选择
                track.removeLast();
            }
        }
    }
}
