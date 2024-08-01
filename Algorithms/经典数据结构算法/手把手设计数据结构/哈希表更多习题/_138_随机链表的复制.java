package Algorithms.经典数据结构算法.手把手设计数据结构.哈希表更多习题;

import java.util.HashMap;

// https://leetcode.cn/problems/copy-list-with-random-pointer/
public class _138_随机链表的复制 {
    // 对于数据结构复制，甭管他怎么变，你就记住最简单的方式：一个哈希表 + 两次遍历。
    // 第一次遍历专门克隆节点，借助哈希表把原始节点和克隆节点的映射存储起来；第二次专门组装节点，照着原数据结构的样子，把克隆节点的指针组装起来。
    // 题目如果让你克隆带随机指针的二叉树，或者克隆图，都是一样的，只不过是遍历的方式从 for 循环迭代遍历变成 traverse 递归函数遍历罢了。

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> originToClone = new HashMap<>();
            // 第一次遍历，先把所有节点克隆出来
            for (Node p = head; p != null; p = p.next) {
                if (!originToClone.containsKey(p)) {
                    originToClone.put(p, new Node(p.val));
                }
            }

            // 第二次遍历，把克隆节点的结构连接好
            for (Node p = head; p != null; p = p.next) {
                if (p.next != null) {
                    originToClone.get(p).next = originToClone.get(p.next);
                }
                if (p.random != null) {
                    originToClone.get(p).random = originToClone.get(p.random);
                }
            }
            
            // 返回克隆之后的头结点
            return originToClone.get(head);
        }
    }
}
