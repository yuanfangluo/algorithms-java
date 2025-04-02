package labuladong._1_经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.PriorityQueue;

// https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix/
public class _378_有序矩阵中第K小的元素 {
    // 矩阵中的每一行都是排好序的，就好比多条有序链表，
    // 你用优先级队列施展合并多条有序链表的逻辑就能找到第 k 小的元素了。

    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            // 存储二元组 (matrix[i][j], i, j)
            // i, j 记录当前元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 按照元素大小升序排序
                return a[0] - b[0];
            });

            // 初始化优先级队列，把每一行的第一个元素装进去
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[] { matrix[i][0], i, 0 });
            }

            int res = -1;
            // 执行合并多个有序链表的逻辑，找到第 k 小的元素
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                // 链表中的下一个节点加入优先级队列
                int i = cur[1], j = cur[2];
                if (j + 1 < matrix[i].length) {
                    pq.add(new int[] { matrix[i][j + 1], i, j + 1 });
                }
            }
            return res;
        }
    }

}
