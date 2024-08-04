
// https://leetcode.cn/problems/next-permutation/
public class _31_下一个排列 {
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            // 从后往前找到第一个小于后一个的数
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            // 从后往前找到第一个大于 nums[i] 的数
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[i] >= nums[j]) {
                    j--;
                }
                // 交换 nums[i] 和 nums[j]
                swap(nums, i, j);
            }
            // 反转 nums[i+1:]
            reverse(nums, i + 1);
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public void reverse(int[] nums, int start) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
    }
}
