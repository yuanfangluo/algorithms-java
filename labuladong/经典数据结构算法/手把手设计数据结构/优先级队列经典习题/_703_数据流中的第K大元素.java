package labuladong.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/kth-largest-element-in-a-stream/
public class _703_数据流中的第K大元素 {
    class KthLargest {

        private int k;
        // 默认是小顶堆
        private PriorityQueue<Integer> pq = new PriorityQueue<>();

        public KthLargest(int k, int[] nums) {
            // 将 nums 装入小顶堆，保留下前 k 大的元素
            for (int e : nums) {
                pq.offer(e);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            this.k = k;
        }

        public int add(int val) {
            // 维护小顶堆只保留前 k 大的元素
            pq.offer(val);
            if (pq.size() > k) {
                pq.poll();
            }
            // 堆顶就是第 k 大元素（即倒数第 k 小的元素）
            return pq.peek();
        }
    }
}
