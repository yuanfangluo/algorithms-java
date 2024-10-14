package Algorithms._1_经典数据结构算法.手把手设计数据结构.单调队列的通用实现及经典习题.单调队列和动态规划;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/first-unique-number/
public class _1429_第一个唯一数字 {
    // 用一个哈希表 count 维护元素的出现次数，调用 showFirstUnique 时借助 count 找到第一个唯一的元素。
    class FirstUnique {
        // 记录每个元素的出现次数
        HashMap<Integer, Integer> count = new HashMap<>();
        // 从队尾添加元素，队头取出元素
        Queue<Integer> q = new LinkedList<>();

        public FirstUnique(int[] nums) {
            // 初始化队列和哈希表
            for (int elem : nums) {
                add(elem);
            }
        }

        public int showFirstUnique() {
            while (!q.isEmpty()) {
                int elem = q.peek();
                if (count.get(elem) > 1) {
                    // 队列中的非唯一元素都弹出
                    q.poll();
                } else {
                    // 直到找到第一个唯一元素
                    return elem;
                }
            }
            // 如果队列弹空了还找不到，那就不存在唯一元素
            return -1;
        }

        public void add(int value) {
            // 加入队列
            q.offer(value);
            // 哈希表中记录出现次数
            int valCount = count.getOrDefault(value, 0);
            count.put(value, valCount + 1);
        }
    }
}
