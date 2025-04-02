package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
public class _117_填充每个节点的下一个右侧节点指针_II {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }

            // 二叉树层序遍历框架
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int sz = q.size();
                // 遍历一层
                Node pre = null;
                for (int i = 0; i < sz; i++) {
                    Node cur = q.poll();
                    // 链接当前层所有节点的 next 指针
                    if (pre != null) {
                        pre.next = cur;
                    }
                    pre = cur;
                    // 将下一层节点装入队列
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
            }
            return root;
        }
    }
}
