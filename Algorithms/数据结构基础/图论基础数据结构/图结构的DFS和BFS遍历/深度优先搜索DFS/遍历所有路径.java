package Algorithms.数据结构基础.图论基础数据结构.图结构的DFS和BFS遍历.深度优先搜索DFS;

import java.util.LinkedList;
import java.util.List;

import Algorithms.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Edge;
import Algorithms.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Graph;

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

        // 对于图结构来说，由起点 src 到目标节点 dest 的路径可能不止一条。
        // 我们需要一个 onPath 数组，在进入节点时（前序位置）标记为正在访问，退出节点时（后序位置）撤销标记，
        // 这样才能遍历图中的所有路径，从而找到 src 到 dest 的所有路径：
        boolean[] onPath = new boolean[graph.size()];

        // 存储路径
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

    // 为啥之前讲的遍历节点就不用撤销 visited 数组的标记，而这里要在后序位置撤销 onPath 数组的标记呢？
    // 因为前文遍历节点的代码中，visited 数组的指责是保证每个节点只会被访问一次。
    // 而对于图结构来说，要想遍历所有路径，可能会多次访问同一个节点，这是关键的区别。
}
