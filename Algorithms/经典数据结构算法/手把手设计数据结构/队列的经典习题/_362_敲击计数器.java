package Algorithms.经典数据结构算法.手把手设计数据结构.队列的经典习题;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/design-hit-counter/
public class _362_敲击计数器 {
    class HitCounter {
    Queue<Integer> q = new LinkedList<>();

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        // 留队列中最近 300 秒的数据即可
        while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        
        return q.size();
    }
}
}
