package labuladong.手把手刷数据结构.数组.前缀和技巧经典题.前缀和与哈希表;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/subarray-sums-divisible-by-k/?show=1
public class _974_和可被K整除的子数组 {
    // sum(nums[i..j]) % k == 0
    // (sum(nums[0..i]) - sum(nums[0..j])) % k == 0
    // sum(nums[0..i]) % k == sum(nums[0..j]) % k
    public int subarraysDivByK11(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int[] preSum = new int[n + 1];
        // preSum[i] = preSum[i-1] + nums[i]
        preSum[0] = 0;

        Map<Integer, Integer> map = new HashMap<>();
        // key为前缀和的余数，value为余数的个数
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            // nums[0...i]的前缀和
            preSum[i + 1] = preSum[i] + nums[i];

            // nums[0...i]的前缀和与k的余数
            int curRemainder = preSum[i + 1] % k;
            if (curRemainder < 0) {
                // 考虑到 preSum[i + 1] 可能是负数，根据 Java 求模的特性，-2 % 3 的结果是 -2
                // 但我们实际想要正余数 1，所以这里需要对 curRemainder 进行调整
                curRemainder += k;
            }
            if (map.containsKey(curRemainder)) {
                int count = map.get(curRemainder);
                res += count;
                map.put(curRemainder, count + 1);

            } else {
                map.put(curRemainder, 1);
            }
        }
        return res;
    }


    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        // nums 的前缀和数组，注意索引偏移，preSum[i] 的值为 sum(nums[0..i-1])
        int[] preSum = new int[n + 1];
        // 前缀和余数的计数器，方便快速查找所需的前缀和余数的数量
        Map<Integer, Integer> remainderToCount = new HashMap<>();
        preSum[0] = 0;
        remainderToCount.put(0, 1);
        // 计算 nums 的前缀和余数并更新计数器
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 计算 nums[0..i] 的前缀和
            preSum[i + 1] = preSum[i] + nums[i];
            // nums[0..i] 的所有元素之和与 k 的余数
            int curRemainder = preSum[i + 1] % k;
            if (curRemainder < 0) {
                // 考虑到 preSum[i + 1] 可能是负数，根据 Java 求模的特性，-2 % 3 的结果是 -2
                // 但我们实际想要正余数 1，所以这里需要对 curRemainder 进行调整
                curRemainder += k;
            }
            // 看看之前 nums[0..i-1] 中是否也存在前缀和余数为 curRemainder 的子数组
            if (remainderToCount.containsKey(curRemainder)) {
                // 如果存在，则说明找到了可以整除 k 的子数组，累加子数组数量
                int count = remainderToCount.get(curRemainder);
                res += count;
                remainderToCount.put(curRemainder, count + 1);
            } else {
                // 如果不存在，那么 nums[0..i] 是第一个前缀和余数为 curRemainder 的子数组
                remainderToCount.put(curRemainder, 1);
            }
        }
        return res;
    }
}
