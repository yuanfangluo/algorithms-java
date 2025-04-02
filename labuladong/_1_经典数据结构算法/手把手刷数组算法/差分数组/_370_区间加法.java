package labuladong._1_经典数据结构算法.手把手刷数组算法.差分数组;

// https://leetcode.cn/problems/range-addition/
public class _370_区间加法 {
    class Solution {
        int[] getModifiedArray(int length, int[][] updates) {
            // nums 初始化为全 0
            int[] nums = new int[length];
            // 构造差分解法
            Difference df = new Difference(nums);

            for (int[] update : updates) {
                int i = update[0];
                int j = update[1];
                int val = update[2];
                df.increment(i, j, val);
            }

            return df.result();
        }
    }
}
