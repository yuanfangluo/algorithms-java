package labuladong._1_经典数据结构算法.手把手刷图算法.Dijkstra算法模板及应用;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.cn/problems/network-delay-time/
public class _743_网络延迟时间 {
    // 让你求所有节点都收到信号的时间，你把所谓的传递时间看做距离，
    // 实际上就是问你「从节点 k 到其他所有节点的最短路径中，最长的那条最短路径距离是多少」，
    // 说白了就是让你算从节点 k 出发到其他所有节点的最短路径，就是标准的 Dijkstra 算法

    // 在用 Dijkstra 之前，别忘了要满足一些条件，加权有向图，没有负权重边，
    // OK，可以用 Dijkstra 算法计算最短路径。

    class Solution {
        int networkDelayTime(int[][] times, int n, int k) {
            // 节点编号是从 1 开始的，所以要一个大小为 n + 1 的邻接表
            List<int[]>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }
            // 构造图
            for (int[] edge : times) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                // from -> List<(to, weight)>
                // 邻接表存储图结构，同时存储权重信息
                graph[from].add(new int[] { to, weight });
            }
            // 启动 dijkstra 算法计算以节点 k 为起点到其他节点的最短路径
            int[] distTo = dijkstra(k, graph);

            // 找到最长的那一条最短路径
            int res = 0;
            for (int i = 1; i < distTo.length; i++) {
                if (distTo[i] == Integer.MAX_VALUE) {
                    // 有节点不可达，返回 -1
                    return -1;
                }
                res = Math.max(res, distTo[i]);
            }
            return res;
        }

        // dijkstra 算法模板
        class State {
            // 图节点的 id
            int id;
            // 从 start 节点到当前节点的距离
            int distFromStart;

            State(int id, int distFromStart) {
                this.id = id;
                this.distFromStart = distFromStart;
            }
        }

        // 输入一个起点 start，计算从 start 到其他节点的最短距离
        int[] dijkstra(int start, List<int[]>[] graph) {

            // 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
            int[] distTo = new int[graph.length];
            Arrays.fill(distTo, Integer.MAX_VALUE);
            // base case，start 到 start 的最短距离就是 0
            distTo[start] = 0;

            // 优先级队列，distFromStart 较小的排在前面
            Queue<State> pq = new PriorityQueue<>((a, b) -> {
                return a.distFromStart - b.distFromStart;
            });
            
            // 从起点 start 开始进行 BFS
            pq.offer(new State(start, 0));

            while (!pq.isEmpty()) {
                State curState = pq.poll();
                int curNodeID = curState.id;
                int curDistFromStart = curState.distFromStart;

                if (curDistFromStart > distTo[curNodeID]) {
                    continue;
                }

                // 将 curNode 的相邻节点装入队列
                for (int[] neighbor : graph[curNodeID]) {
                    int nextNodeID = neighbor[0];
                    int distToNextNode = distTo[curNodeID] + neighbor[1];
                    // 更新 dp table
                    if (distTo[nextNodeID] > distToNextNode) {
                        distTo[nextNodeID] = distToNextNode;
                        pq.offer(new State(nextNodeID, distToNextNode));
                    }
                }
            }
            return distTo;
        }
    }
}
