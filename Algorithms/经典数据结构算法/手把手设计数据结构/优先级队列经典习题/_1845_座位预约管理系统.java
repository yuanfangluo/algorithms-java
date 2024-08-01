package Algorithms.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/seat-reservation-manager/
public class _1845_座位预约管理系统 {
    class SeatManager {
    // 利用优先级队列自动排序，队头的元素就是最小的
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public SeatManager(int n) {
        // 初始化所有空闲座位
        for (int i = 1; i <= n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        // 拿出队头元素（最小）
        return pq.poll();
    }

    public void unreserve(int i) {
        pq.offer(i);
    }
}
}
