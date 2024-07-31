package labuladong.经典数据结构算法.手把手刷图算法.Dijkstra算法模板及应用;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 多叉树的层序遍历框架 {
    class Node {
        int val;
        List<Node> children;
    }

    // 输入一棵多叉树的根节点，层序遍历这棵多叉树
    void levelTraverse(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        // 从上到下遍历多叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();

                System.out.println("节点" + cur.val + "在第" + depth + "层");

                // 将下一层节点放入队列
                for (Node child : cur.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }
}
