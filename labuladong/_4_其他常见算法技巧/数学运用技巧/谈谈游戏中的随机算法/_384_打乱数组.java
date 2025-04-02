package labuladong._4_其他常见算法技巧.数学运用技巧.谈谈游戏中的随机算法;

import java.util.Arrays;
import java.util.Random;

public class _384_打乱数组 {
    class Solution {
        private int[] nums;
        private Random rand = new Random();

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int[] reset() {
            return nums;
        }

        // 洗牌算法
        public int[] shuffle() {
            int n = nums.length;
            int[] copy = Arrays.copyOf(nums, n);
            for (int i = 0; i < n; i++) {
                // 我们要生成一个 [i, n-1] 区间内的随机数
                // i + [0, n-i-1] 区间内的随机数
                // [i, n-1] 区间内的随机数
                int r = i + rand.nextInt(n - i);
                // 交换 nums[i] 和 nums[r]
                swap(copy, i, r);
            }
            return copy;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
