package labuladong.数据结构基础.图论基础数据结构.图结构的DFS和BFS遍历.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Edge;
import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Graph;

public class 层序遍历记录步数 {
    class Solution1 {
        class Node {
            int val;
            List<Node> children;
        }

        // 多叉树的层序遍历
        void levelOrderTraverse(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            // 记录当前遍历到的层数（根节点视为第 1 层）
            int depth = 1;

            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    Node cur = q.poll();
                    // 访问 cur 节点，同时知道它所在的层数
                    System.out.println("depth = " + depth + ", val = " + cur.val);

                    for (Node child : cur.children) {
                        q.offer(child);
                    }
                }
                depth++;
            }
        }
    }

    // BFS 遍历图的所有节点，从 s 开始进行 BFS，且记录遍历的步数
    // 这个 step 变量记录了从起点 s 开始的遍历步数，对于无权图来说，相当于每条边的权重都是 1，这个变量就可以辅助我们判断最短路径。
    // 对于加权图，由于每条边的权重不同，遍历的步数不再能代表最短路径的长度，这时候就需要用 Dijkstra 算法 了
    class Solution2 {
        void bfs(Graph graph, int s) {
            boolean[] visited = new boolean[graph.size()];
            Queue<Integer> q = new LinkedList<>();
            q.offer(s);
            visited[s] = true;
            // 记录遍历的步数
            int step = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                System.out.println("visit " + cur + " at step " + step);
                for (Edge e : graph.neighbors(cur)) {
                    if (!visited[e.to]) {
                        q.offer(e.to);
                        visited[e.to] = true;
                    }
                }
                step++;
            }
        }
    }
}
