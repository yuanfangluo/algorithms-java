package labuladong.经典数据结构算法.手把手刷图算法.二分图判定算法;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/possible-bipartition/
public class _886_可能的二分法 {
    // 二分图判定算法
    class Solution {
        private boolean ok = true;
        private boolean[] color;
        private boolean[] visited;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 图节点编号从 1 开始
            color = new boolean[n + 1];
            visited = new boolean[n + 1];
            // 转化成邻接表表示图结构
            List<Integer>[] graph = buildGraph(n, dislikes);

            for (int v = 1; v <= n; v++) {
                if (!visited[v]) {
                    traverse(graph, v);
                }
            }

            return ok;
        }

        // 建图函数
        private List<Integer>[] buildGraph(int n, int[][] dislikes) {
            // 图节点编号为 1...n
            List<Integer>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : dislikes) {
                int v = edge[1];
                int w = edge[0];
                // 「无向图」相当于「双向图」
                // v -> w
                graph[v].add(w);
                // w -> v
                graph[w].add(v);
            }
            return graph;
        }

        private void traverse(List<Integer>[] graph, int v) {
            if (!ok)
                return;
            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    color[w] = !color[v];
                    traverse(graph, w);
                } else {
                    if (color[w] == color[v]) {
                        ok = false;
                        return;
                    }
                }
            }
        }
    }
}
