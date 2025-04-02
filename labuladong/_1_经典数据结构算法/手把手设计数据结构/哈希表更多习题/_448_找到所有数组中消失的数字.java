package labuladong._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
public class _448_找到所有数组中消失的数字 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            int[] count = new int[n + 1];
            for (int num : nums) {
                count[num]++;
            }
            List<Integer> res = new LinkedList<>();
            for (int num = 1; num <= n; num++) {
                if (count[num] == 0) {
                    res.add(num);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int num : nums) {
                // 注意索引，nums 中元素大小从 1 开始，
                // 而索引是从 0 开始的，所以有一位索引偏移
                if (nums[Math.abs(num) - 1] < 0) {
                    // 之前已经把对应索引的元素变成负数了，
                    // 这说明 num 重复出现了两次，但我们什么都不用做，让索引继续保持负数
                } else {
                    // 把索引 num - 1 置为负数
                    nums[Math.abs(num) - 1] *= -1;
                }
            }

            List<Integer> res = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    // 说明没有元素和这个索引对应，即找到一个缺失元素
                    res.add(i + 1);
                }
            }

            return res;
        }
    }
}
