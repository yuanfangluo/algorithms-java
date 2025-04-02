package labuladong._2_经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.Arrays;

// https://leetcode.cn/problems/letter-tile-possibilities/
public class _1079_活字印刷 {
    class Solution {

        int res = 0;
        boolean[] used;

        public int numTilePossibilities(String s) {
            char[] nums = s.toCharArray();
            // 先排序，让相同的元素靠在一起
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            // 剪掉掉空集
            return res - 1;
        }

        void backtrack(char[] nums) {
            res++;
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                backtrack(nums);
                used[i] = false;
            }
        }
    }

}
