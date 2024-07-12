package labuladong.手把手刷数据结构.数组.前缀和技巧经典题.前缀和与哈希表;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.cn/problems/contiguous-array/
*
* */
public class _525_连续数组 {

    /*
    * 首先，我们做一个等价，题目让你找 0 和 1 数量相同的最长子数组，
    * 如果我们把 0 视作 -1，就把题目转变成了：寻找和为 0 的最长子数组。
    *
    * 涉及到和为 xxx 的子数组，就是要考察 前缀和技巧 和哈希表的结合使用了。
    *
    * 求和为 0 的最长子数组，相当于让你去 preSum 数组中找 i, j，
    * 使得 preSum[i] - preSum[j] == 0，其中 i > j 且 i - j 要尽可能大。
    *
    * 那么我们用一个哈希表 valToIndex 存储前缀和到索引的映射，给定任意 preSum[i]，
    * 我们都能通过 valToIndex 快速判断是否存在 j，使得 preSum[i] - preSum[j] == 0。
    *
    * */

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }

        // 前缀和到索引的映射，方便快速查找所需的前缀和
        Map<Integer, Integer> valToIndex = new HashMap<>();

        int res = 0;

        for (int i = 0; i < preSum.length; i++) {
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.containsKey(preSum[i])) {
                valToIndex.put(preSum[i], i);
            } else {
                // 到这里代表这个前缀和已经出现过了，则找到一个和为 0 的子数组
                res = Math.max(res, i - valToIndex.get(preSum[i]));
            }
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
        }
        return res;
    }
}
