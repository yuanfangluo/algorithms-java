package labuladong.数据结构基础.图论基础数据结构.图结构的DFS和BFS遍历.DFS;

import java.util.LinkedList;
import java.util.List;

import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Edge;
import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Graph;

public class 遍历所有路径 {
    // 多叉树遍历路径框架
    class Solution1 {
        class Node {
            int val;
            List<Node> children;
        }

        // 多叉树的遍历框架，寻找从根节点到目标节点的路径
        List<Node> path = new LinkedList<>();

        void traverse(Node root, Node targetNode) {
            // base case
            if (root == null) {
                return;
            }
            // 前序位置
            path.addLast(root);
            if (root.val == targetNode.val) {
                System.out.println("find path: " + path);
            }
            for (Node child : root.children) {
                traverse(child, targetNode);
            }
            // 后序位置
            path.removeLast();
        }
    }

    // 图遍历框架
    class Solution2 {
        Graph graph;

        // 遍历图的所有路径
        boolean[] onPath = new boolean[graph.size()];
        List<Integer> path = new LinkedList<>();

        void traverse(Graph graph, int src, int dest) {
            // base case
            if (src < 0 || src >= graph.size()) {
                return;
            }
            if (onPath[src]) {
                // 防止死循环
                return;
            }
            // 前序位置
            onPath[src] = true;
            path.add(src);
            if (src == dest) {
                System.out.println("find path: " + path);
            }
            for (Edge e : graph.neighbors(src)) {
                traverse(graph, e.to, dest);
            }
            // 后序位置
            path.remove(path.size() - 1);
            onPath[src] = false;
        }
    }
}
