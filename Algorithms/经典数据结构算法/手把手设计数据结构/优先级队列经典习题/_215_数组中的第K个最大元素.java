package Algorithms.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class _215_数组中的第K个最大元素 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }
            while (queue.size() > k) {
                queue.poll();
            }
            return queue.peek();
        }
    }
}
