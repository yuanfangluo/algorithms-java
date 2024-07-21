package labuladong.手把手刷数据结构.手把手设计数据结构.队列的经典习题;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/number-of-recent-calls/
public class _933_最近的请求次数 {
    class RecentCounter {

        Queue<Integer> q = new LinkedList<>();

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                // t 是递增的，所以可以从队头删除 3000 毫秒之前的请求
                q.poll();
            }

            return q.size();
        }
    }
}
