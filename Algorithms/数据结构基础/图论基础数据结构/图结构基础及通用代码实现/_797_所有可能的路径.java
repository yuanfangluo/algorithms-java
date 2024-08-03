package Algorithms.数据结构基础.图论基础数据结构.图结构基础及通用代码实现;

import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/all-paths-from-source-to-target/
public class _797_所有可能的路径 {

    class Solution {
        // 记录所有路径
        List<List<Integer>> res = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            // 维护递归过程中经过的路径
            LinkedList<Integer> path = new LinkedList<>();
            traverse(graph, 0, path);
            return res;
        }

        /* 图的遍历框架 */
        void traverse(int[][] graph, int s, LinkedList<Integer> path) {
            // 添加节点 s 到路径
            path.addLast(s);
            int n = graph.length;
            if (s == n - 1) {
                // 到达终点
                res.add(new LinkedList<>(path));
                // 可以在这直接 return，但要 removeLast 正确维护 path
                // path.removeLast();
                // return;
                // 不 return 也可以，因为图中不包含环，不会出现无限递归
            }

            // 递归每个相邻节点
            for (int v : graph[s]) {
                traverse(graph, v, path);
            }

            // 从路径移出节点 s
            path.removeLast();
        }
    }
}
