package labuladong._1_经典数据结构算法.手把手设计数据结构.队列的经典习题;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/moving-average-from-data-stream/
public class _346_数据流中的移动平均值 {
    class MovingAverage {
        // 维护定长队列和队列中的元素和
        int maxSize, queueSum = 0;
        Queue<Integer> q = new LinkedList<>();

        public MovingAverage(int size) {
            maxSize = size;
        }

        public double next(int val) {
            if (q.size() == maxSize) {
                // 给新元素腾位置
                int deletedVal = q.poll();
                queueSum -= deletedVal;
            }

            // 加入新元素
            q.offer(val);
            queueSum += val;
            return (double) queueSum / q.size();
        }
    }
}
