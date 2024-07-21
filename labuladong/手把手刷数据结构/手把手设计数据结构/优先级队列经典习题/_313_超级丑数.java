package labuladong.手把手刷数据结构.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/super-ugly-number/
public class _313_超级丑数 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            // 优先队列中装三元组 int[] {product, prime, pi}
            // 其中 product 代表链表节点的值，prime 是计算下一个节点所需的质数因子，pi 代表链表上的指针
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                return a[0] - b[0];
            });

            // 把多条链表的头结点加入优先级队列
            for (int i = 0; i < primes.length; i++) {
                pq.offer(new int[] { 1, primes[i], 1 });
            }

            // 可以理解为最终合并的有序链表（结果链表）
            int[] ugly = new int[n + 1];
            // 可以理解为结果链表上的指针
            int p = 1;

            while (p <= n) {
                // 取三个链表的最小结点
                int[] pair = pq.poll();
                int product = pair[0];
                int prime = pair[1];
                int index = pair[2];

                // 避免结果链表出现重复元素
                if (product != ugly[p - 1]) {
                    // 接到结果链表上
                    ugly[p] = product;
                    p++;
                }

                // 生成下一个节点加入优先级队列
                int[] nextPair = new int[] { ugly[index] * prime, prime, index + 1 };
                pq.offer(nextPair);
            }
            return ugly[n];
        }
    }
}
