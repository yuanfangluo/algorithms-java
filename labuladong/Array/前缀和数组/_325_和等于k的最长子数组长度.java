package labuladong.Array.前缀和数组;

import java.util.HashMap;
import java.util.Map;

public class _325_和等于k的最长子数组长度 {
    public static void main(String[] args) {
        int[] nums = {1,-1,5,-2,3};
        System.out.println(maxSubArrayLen(nums, 3));
    }

    // 寻找 i, j 使得 preSum[i] - preSum[j] == k 且 i - j 尽可能的大。
    // preSum[i] - preSum[j] == k 其实就是 preSum[j] == preSum[i] - k
    // 所以我们使用一个哈希表，记录 preSum[i] 的值以及这个前缀和第一次出现的索引，就可以迅速判断 preSum[i]
    // 是否符合条件并计算最长子数组长度了。
    public static int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        // preSum 中的值 -> 对应的最小索引
        // 比如 preSum = [2,4,1,3,4]，preSumToIndex[4] = 1
        Map<Integer, Integer> preSumToIndex = new HashMap<>();
        int maxLen = 0;
        // 前缀和数组（在这道题中可以优化为一个变量）
        int preSum = 0;
        // base case，这样索引相减的时候可以算出正确的子数组长度
        preSumToIndex.put(0, -1);
        for (int i = 0; i < n; i++) {
            // 计算前缀和，维护 preSum = sum(nums[0..i])
            preSum += nums[i];
            // 确保 preSumToIndex 中记录的索引是第一次出现的位置
            preSumToIndex.putIfAbsent(preSum, i);

            int need = preSum - k;

            if (preSumToIndex.containsKey(need)) {
                int j = preSumToIndex.get(need);
                // nums[j..i] 是和为 k 的子数组
                maxLen = Math.max(maxLen, i - j);
            }
        }
        return maxLen;
    }
}
