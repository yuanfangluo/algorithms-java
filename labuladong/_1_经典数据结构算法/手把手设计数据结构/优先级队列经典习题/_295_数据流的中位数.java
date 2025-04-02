package labuladong._1_经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/find-median-from-data-stream/
public class _295_数据流的中位数 {
    class MedianFinder {
        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            // 小顶堆
            large = new PriorityQueue<>();
            // 大顶堆
            small = new PriorityQueue<>((a, b) -> {
                return b - a;
            });
        }

        public double findMedian() {
            // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
            if (large.size() < small.size()) {
                return small.peek();
            } else if (large.size() > small.size()) {
                return large.peek();
            }
            // 如果元素一样多，两个堆堆顶元素的平均数是中位数
            return (large.peek() + small.peek()) / 2.0;

        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }
    }
}
