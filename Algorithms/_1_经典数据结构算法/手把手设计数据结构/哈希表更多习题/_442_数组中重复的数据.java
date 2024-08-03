package Algorithms._1_经典数据结构算法.手把手设计数据结构.哈希表更多习题;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/find-all-duplicates-in-an-array/
public class _442_数组中重复的数据 {

    // 用哈希集合很容易找到 nums 中那些重复的元素
    class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            int n = nums.length;
            List<Integer> res = new LinkedList<>();
            // 用数组模拟哈希集合
            int[] seen = new int[n + 1];
            for (int num : nums) {
                if (seen[num] == 0) {
                    // 添加到哈希集合
                    seen[num] = 1;
                } else {
                    // 找到重复元素
                    res.add(num);
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new LinkedList<>();
            for (int num : nums) {
                // 注意索引，nums 中元素大小从 1 开始，
                // 而索引是从 0 开始的，所以有一位索引偏移
                if (nums[Math.abs(num) - 1] < 0) {
                    // 之前已经把对应索引的元素变成负数了，
                    // 这说明 num 重复出现了两次
                    res.add(Math.abs(num));
                } else {
                    // 把索引 num - 1 置为负数
                    nums[Math.abs(num) - 1] *= -1;
                }
            }
    
            return res;
        }
    }
}
