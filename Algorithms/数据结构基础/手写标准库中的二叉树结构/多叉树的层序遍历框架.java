package Algorithms.数据结构基础.手写标准库中的二叉树结构;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.Node;

public class 多叉树的层序遍历框架 {
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

    class Solution2 {
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
}
