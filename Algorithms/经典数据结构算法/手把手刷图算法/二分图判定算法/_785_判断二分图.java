package Algorithms.经典数据结构算法.手把手刷图算法.二分图判定算法;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/is-graph-bipartite/
public class _785_判断二分图 {
    // 现实生活中二分图解决了什么问题？
    // 二分图结构在某些场景可以更高效地存储数据
    // 例如电影和演员的关系

    // 二分图判定思路
    // 判定二分图的算法很简单，就是用代码解决「双色问题」。
    // 说白了就是遍历一遍图，一边遍历一边染色，看看能不能用两种颜色给所有节点染色，且相邻节点的颜色都不相同。

    // 既然说到遍历图，也不涉及最短路径之类的，当然是 DFS 算法和 BFS 皆可了，
    // DFS 算法相对更常用些，所以我们先来看看如何用 DFS 算法判定双色图。
    // 结合之前的代码框架，我们可以额外使用一个 color 数组来记录每个节点的颜色

    class Solution1 {
        // 记录图是否符合二分图性质
        private boolean ok = true;
        // 记录图中节点的颜色，false 和 true 代表两种不同颜色
        private boolean[] color;
        // 记录图中节点是否被访问过
        private boolean[] visited;

        // 主函数，输入邻接表，判断是否是二分图
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new boolean[n];
            visited = new boolean[n];

            // 因为图不一定是联通的，可能存在多个子图
            // 所以要把每个节点都作为起点进行一次遍历
            // 如果发现任何一个子图不是二分图，整幅图都不算二分图
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    traverse(graph, v);
                }
            }
            return ok;
        }

        // DFS 遍历框架
        private void traverse(int[][] graph, int v) {
            // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
            if (!ok)
                return;
            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 相邻节点 w 没有被访问过
                    // 那么应该给节点 w 涂上和节点 v 不同的颜色
                    color[w] = !color[v];
                    // 继续遍历 w
                    traverse(graph, w);
                } else {
                    // 相邻节点 w 已经被访问过
                    // 根据 v 和 w 的颜色判断是否是二分图
                    if (color[w] == color[v]) {
                        // 若相同，则此图不是二分图
                        ok = false;
                        return;
                    }
                }
            }
        }
    }

    // 使用BFS来解决
    class Solution2 {
        // 记录图是否符合二分图性质
        private boolean ok = true;
        // 记录图中节点是否被访问过
        private boolean[] visited;
        // 记录图中节点的颜色，false 和 true 代表两种不同颜色
        private boolean[] color;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new boolean[n];
            visited = new boolean[n];

            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    // 改为使用 BFS 函数
                    bfs(graph, v);
                }
            }
            
            return ok;
        }

        // 从 start 节点开始进行 BFS 遍历
        private void bfs(int[][] graph, int start) {
            Queue<Integer> q = new LinkedList<>();
            visited[start] = true;
            q.offer(start);

            while (!q.isEmpty() && ok) {
                int v = q.poll();
                // 从节点 v 向所有相邻节点扩散
                for (int w : graph[v]) {
                    if (!visited[w]) {
                        // 相邻节点 w 没有被访问过
                        // 那么应该给节点 w 涂上和节点 v 不同的颜色
                        color[w] = !color[v];
                        // 标记 w 节点，并放入队列
                        visited[w] = true;
                        q.offer(w);
                    } else {
                        // 相邻节点 w 已经被访问过
                        // 根据 v 和 w 的颜色判断是否是二分图
                        if (color[w] == color[v]) {
                            // 若相同，则此图不是二分图
                            ok = false;
                            return;
                        }
                    }
                }
            }
        }
    }
}
