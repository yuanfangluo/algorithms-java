package labuladong.手把手刷数据结构.手把手刷数组算法.前缀和技巧经典题.前缀和与哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description
 * 
 */
public class _560_和为K的子数组 {

    // 需要在维护 preSum 前缀和数组的同时动态维护 count 映射，
    // 而不能等到 preSum 计算完成后再处理 count，
    // 因为 count[need] 应该维护 preSum[0..i] 中值为 need 的元素个数。

    public int subarraySum11(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int res = 0;

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }
            count.put(preSum[i], count.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }


    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        // 方便快速查找所需的前缀和
        // [前缀和:出现该前缀和的次数]
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        // 记录和为 k 的子数组个数
        int res = 0;

        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // 如果之前存在值为 need 的前缀和
            // 说明存在以 nums[i-1] 结尾的子数组的和为 k
            int need = preSum[i] - k;
            if (count.containsKey(need)) {
                res += count.get(need);
            }

            // 将当前前缀和存入哈希表
            count.put(preSum[i], count.getOrDefault(preSum[i], 0) + 1);
        }
        return res;
    }
}
