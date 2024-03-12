package LeetCode._2_数组;
// https://leetcode.cn/problems/sum-of-subarray-minimums/


public class _907_子数组的最小值之和 {
    public int sumSubarrayMins(int[] nums) {
        int MOD = (int) (1e9 + 7);
        int n = nums.length;
        int[] stk = new int[n + 1];
        int p = 0;
        stk[0] = -1;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            while (p > 0 && nums[stk[p]] >= nums[i]) {
                int j = stk[p--];
                sum = (int) ((sum + (1L * nums[j] * (i - j) * (j - stk[p])) % MOD) % MOD);
            }
            stk[++p] = i;
        }

        while (p > 0) {
            int j = stk[p--];
            sum = (int) ((sum + (1L * nums[j] * (n - j) * (j - stk[p])) % MOD) % MOD);
        }
        return sum;
    }
    
    public static void main(String[] args) {
        
    }
}
