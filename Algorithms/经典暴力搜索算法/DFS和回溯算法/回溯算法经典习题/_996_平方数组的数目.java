package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法经典习题;

import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.cn/problems/number-of-squareful-arrays/
public class _996_平方数组的数目 {
    class Solution {
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used;

        int count = 0;

        public int numSquarefulPerms(int[] nums) {
            Arrays.sort(nums);
            used = new boolean[nums.length];
            backtrack(nums);
            return count;
        }

        void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                // 本题求合法排列总数，直接累加即可
                count++;
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                // 本题新增的剪枝逻辑，仅相邻元素之和为完全平方数时，才是本题的合法排列
                if (track.size() > 0 && !isSquareful(track.getLast(), nums[i])) {
                    continue;
                }

                track.add(nums[i]);
                used[i] = true;
                backtrack(nums);
                track.removeLast();
                used[i] = false;
            }
        }

        // 判断两个数 a 和 b 的和是否是一个完全平方数
        boolean isSquareful(int a, int b) {
            int c = (int) Math.sqrt(a + b);
            return c * c == a + b;
        }
    }
}
