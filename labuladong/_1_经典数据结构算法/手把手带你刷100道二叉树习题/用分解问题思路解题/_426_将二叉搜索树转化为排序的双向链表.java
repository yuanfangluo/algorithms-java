package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.cn/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
public class _426_将二叉搜索树转化为排序的双向链表 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    // 想把整棵 BST 变成环形链表，可以先把左右子树变成环形链表，然后把 root.val 接在中间，这样就形成了整棵 BST 的环形链表。

    // 定义：输入一棵 BST，返回该 BST 改造成的环形链表的头结点
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        // 先把左右子树都变成环形链表
        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);
        Node leftTail, rightTail;

        // 根节点接到左右两个环形链表中间
        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            leftTail = leftHead = root;
        }

        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightTail = rightHead = root;
        }

        // 两个环形链表头尾相接形成大的环形链表
        leftHead.left = rightTail;
        rightTail.right = leftHead;

        return leftHead;
    }

    class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        Node cur = root;
        Node pre = null;
        Node head = null;
        while(!deque.isEmpty() || cur !=null){
            while(cur != null){
                deque.addFirst(cur);
                cur = cur.left;
            }
            cur = deque.removeFirst();
            if(head ==null){
                head = cur;
            } else{
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        head.left = pre;
        pre.right = head;
        return head;

    }
}
}
