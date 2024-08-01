package Algorithms.经典数据结构算法.手把手设计数据结构.优先级队列经典习题;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/single-threaded-cpu/
public class _1834_单线程CPU {
    // 难点在于你要同时控制三个变量（开始时间、处理时间、索引）的有序性，而且这三个变量还有优先级：

    // 首先应该考虑开始时间，因为只要到了开始时间，任务才进入可执行状态；

    // 其次应该考虑任务的处理时间，在所有可以执行的任务中优先选择处理时间最短的；

    // 如果存在处理时间相同的任务，那么优先选择索引最小的。

    class Solution {
        public int[] getOrder(int[][] tasks) {
            int n = tasks.length;

            // 把原始索引也添加上，方便后面排序用
            ArrayList<int[]> triples = new ArrayList<>();
            for (int i = 0; i < tasks.length; i++) {
                triples.add(new int[] { tasks[i][0], tasks[i][1], i });
            }

            // 数组先按照任务的开始时间排序
            triples.sort((a, b) -> {
                return a[0] - b[0];
            });

            // 按照任务的处理时间排序，如果处理时间相同，按照原始索引排序
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[1] != b[1]) {
                    // 比较处理时间
                    return a[1] - b[1];
                }
                // 比较原始索引
                return a[2] - b[2];
            });

            ArrayList<Integer> res = new ArrayList<>();

            // 记录完成任务的时间线
            int now = 0;
            int i = 0;

            while (res.size() < n) {
                if (!pq.isEmpty()) {
                    // 完成队列中的一个任务
                    int[] triple = pq.poll();
                    
                    res.add(triple[2]);
                    // 每完成一个任务，就要推进时间线
                    now += triple[1];

                } else if (i < n && triples.get(i)[0] > now) {

                    // 队列为空可能因为还没到开始时间，
                    // 直接把时间线推进到最近任务的开始时间
                    now = triples.get(i)[0];
                }

                // 由于时间线的推进，会产生可以开始执行的任务
                for (; i < n && triples.get(i)[0] <= now; i++) {
                    pq.offer(triples.get(i));
                }
            }

            // Java 语言特性，将 List 转化成 int[] 格式
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = res.get(j);
            }
            return arr;
        }
    }

}
