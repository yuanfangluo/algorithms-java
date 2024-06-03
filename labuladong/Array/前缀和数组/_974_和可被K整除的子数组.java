package labuladong.Array.前缀和数组;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/subarray-sums-divisible-by-k/?show=1
public class _974_和可被K整除的子数组 {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        System.out.println(subarraysDivByK(nums, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {
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
        System.out.println(Arrays.toString(preSum));
        System.out.println(remainderToCount);
        return res;
    }
}
