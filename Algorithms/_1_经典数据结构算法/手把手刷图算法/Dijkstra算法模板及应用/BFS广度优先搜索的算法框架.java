package Algorithms._1_经典数据结构算法.手把手刷图算法.Dijkstra算法模板及应用;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS广度优先搜索的算法框架 {
    class Node {
        int val;
        List<Node> children;
    }

    // 输入起点，进行 BFS 搜索
    int BFS(Node start) {
        Queue<Node> q = new LinkedList<>(); // 核心数据结构
        Set<Node> visited = new HashSet<>(); // 避免走回头路

        q.offer(start); // 将起点加入队列
        visited.add(start);

        int step = 0; // 记录搜索的步数
        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散一步 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                System.out.println("从" + start + "到" + cur.val + "的最短距离是" + step);
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.children) {
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
            step++;
        }
        return step;
    }
}
