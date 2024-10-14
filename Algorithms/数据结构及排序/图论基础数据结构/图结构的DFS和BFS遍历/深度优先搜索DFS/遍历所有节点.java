package Algorithms.数据结构及排序.图论基础数据结构.图结构的DFS和BFS遍历.深度优先搜索DFS;

import java.util.List;

import Algorithms.数据结构及排序.图论基础数据结构.图结构基础及通用代码实现.*;

public class 遍历所有节点 {
    // 多叉树的遍历框架
    class Solution1 {
        // 多叉树节点
        class Node {
            int val;
            List<Node> children;
        }

        // 多叉树的遍历框架
        void traverse(Node root) {
            // base case
            if (root == null) {
                return;
            }
            // 前序位置
            System.out.println("visit " + root.val);
            for (Node child : root.children) {
                traverse(child);
            }
            // 后序位置
        }
    }

    // 图的遍历框架
    class Solution2 {
        // 图节点
        class Vertex {
            int id;
            Vertex[] neighbors;
        }

        // 需要一个 visited 数组记录被遍历过的节点
        // 避免走回头路陷入死循环
        boolean[] visited;

        void traverse(Vertex s) {
            // base case
            if (s == null) {
                return;
            }
            if (visited[s.id]) {
                // 防止死循环
                return;
            }
            // 前序位置
            visited[s.id] = true;
            System.out.println("visit " + s.id);
            for (Vertex neighbor : s.neighbors) {
                traverse(neighbor);
            }
            // 后序位置
        }
    }

    // 基于邻接表/邻接矩阵的图遍历代码
    class Solution3 {
        Graph graph;
        // 遍历图的所有节点
        boolean[] visited = new boolean[graph.size()];

        void traverse(Graph graph, int s) {
            // base case
            if (s < 0 || s >= graph.size()) {
                return;
            }
            if (visited[s]) {
                // 防止死循环
                return;
            }
            // 前序位置
            visited[s] = true;
            System.out.println("visit " + s);
            for (Edge e : graph.neighbors(s)) {
                traverse(graph, e.to);
            }
            // 后序位置
        }
    }
}
