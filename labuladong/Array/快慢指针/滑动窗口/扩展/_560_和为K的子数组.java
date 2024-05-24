package labuladong.Array.快慢指针.滑动窗口.扩展;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/subarray-sum-equals-k/description
 * 
 */
public class _560_和为K的子数组 {
    public static void main(String[] args) {
      _560_和为K的子数组 object = new _560_和为K的子数组();
      object.test1();
      object.test2();
    }

    void test1() {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(new _560_和为K的子数组().subarraySum(nums, k));
    }

    void test2() {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new _560_和为K的子数组().subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 前缀和数组
        int[] preSum = new int[n + 1];
        preSum[0] = 0;

        // 方便快速查找所需的前缀和
        // [前缀和:出现该前缀和的次数]
        HashMap<Integer, Integer> count = new HashMap<>();

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
