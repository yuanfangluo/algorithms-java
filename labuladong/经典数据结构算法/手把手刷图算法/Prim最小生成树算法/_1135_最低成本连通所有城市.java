package labuladong.经典数据结构算法.手把手刷图算法.Prim最小生成树算法;

import java.util.LinkedList;
import java.util.List;

import labuladong.Base.Prim;

// https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
public class _1135_最低成本连通所有城市 {
    class Solution {
    public int minimumCost(int n, int[][] connections) {
        // 转化成无向图邻接表的形式
        List<int[]>[] graph = buildGraph(n, connections);
        // 执行 Prim 算法
        Prim prim = new Prim(graph);

        if (!prim.allConnected()) {
            // 最小生成树无法覆盖所有节点
            return -1;
        }

        return prim.weightSum();
    }

    List<int[]>[] buildGraph(int n, int[][] connections) {
        // 图中共有 n 个节点
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] conn : connections) {
            // 题目给的节点编号是从 1 开始的，
            // 但我们实现的 Prim 算法需要从 0 开始编号
            int u = conn[0] - 1;
            int v = conn[1] - 1;
            int weight = conn[2];
            // 「无向图」其实就是「双向图」
            // 一条边表示为 int[]{from, to, weight}
            graph[u].add(new int[]{u, v, weight});
            graph[v].add(new int[]{v, u, weight});
        }
        return graph;
    }
}

}
