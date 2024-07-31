package labuladong.数据结构基础.图论基础数据结构.图结构的DFS和BFS遍历.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Edge;
import labuladong.数据结构基础.图论基础数据结构.图结构基础及通用代码实现.Graph;

public class 层序遍历不记录步数 {
    class Node {
        int val;
        List<Node> children;
    }

    // 多叉树的层序遍历
    class Solution1 {
        void levelOrderTraverse(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Node cur = q.poll();
                // 访问 cur 节点
                System.out.println(cur.val);

                // 把 cur 的所有子节点加入队列
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
        }
    }

    // 图结构的 BFS 遍历，从节点 s 开始进行 BFS
    // 不记录步数
    class Solution2 {
        void bfs(Graph graph, int s) {
            boolean[] visited = new boolean[graph.size()];
            Queue<Integer> q = new LinkedList<>();
            q.offer(s);
            visited[s] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                System.out.println("visit " + cur);
                for (Edge e : graph.neighbors(cur)) {
                    if (!visited[e.to]) {
                        q.offer(e.to);
                        visited[e.to] = true;
                    }
                }
            }
        }
    }

    // 记录步数

}
