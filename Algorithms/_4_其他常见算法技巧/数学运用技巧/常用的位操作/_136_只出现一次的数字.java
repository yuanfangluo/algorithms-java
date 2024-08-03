package Algorithms._4_其他常见算法技巧.数学运用技巧.常用的位操作;

// https://leetcode.cn/problems/single-number/
public class _136_只出现一次的数字 {
    int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
