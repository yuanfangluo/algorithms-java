package Algorithms._0_核心框架汇总.BFS算法解题套路框架;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import Algorithms.Base.Node;

public class BFS算法框架 {
    // 一般来说在找最短路径的时候使用 BFS
    int BFS(Node start, Node target) {
        Queue<Node> q = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        q.offer(start);
        visited.add(start);

        int step = 0; // 记录扩散的步数

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                /* 划重点：这里判断是否到达终点 */
                if (cur.val == target.val)
                    return step;
                /* 将 cur 的相邻节点加入队列 */
                for (Node x : cur.children) {
                    if (!visited.contains(x)) {
                        q.offer(x);
                        visited.add(x);
                    }
                }
            }
        }
        // 如果走到这里，说明在图中没有找到目标节点
        return -1;

    }
}
