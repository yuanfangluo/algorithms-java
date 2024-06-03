package labuladong.Array.前缀和数组;

import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.cn/problems/continuous-subarray-sum/
*
* */
public class _523_连续的子数组和 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 计算 nums 的前缀和
        int[] preSum = new int[n + 1];
        // preSum[0] = 0
        // preSum[1] = preSum[0] + nums[0]
        // ...
        // preSum[n] = preSum[n - 1] + nums[n - 1]
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 前缀和与k的余数到索引的映射，方便快速查找所需的前缀和
        Map<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            int val = preSum[i] % k;
            // 如果这个前缀和已经有对应的索引了，则什么都不做
            // 如果这个余数还没有对应的索引，则记录下来
            if (!valToIndex.containsKey(val)) {
                valToIndex.put(val, i);
            }
        }

        for (int i = 1; i < preSum.length; i++) {
            int need = preSum[i] % k;
            if (valToIndex.containsKey(need)) {
                if (i - valToIndex.get(need) >= 2) {
                    return true;
                }
            }

        }
        return false;
    }
}
