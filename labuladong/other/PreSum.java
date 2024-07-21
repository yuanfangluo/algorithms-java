package labuladong.other;

public class PreSum {

    int[] create(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        return preSum;
    }
}
