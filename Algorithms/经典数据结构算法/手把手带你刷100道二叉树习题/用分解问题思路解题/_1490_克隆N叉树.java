package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/clone-n-ary-tree/
public class _1490_克隆N叉树 {
    // 这道题比较简单：你想让我复制整棵树，那么我先复制根节点，然后递归调用 cloneTree 去复制所有子树（子问题）。
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    // 定义：输入 N 叉树节点，返回以该节点为根的 N 叉树的深拷贝
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }

        // 先拷贝根节点
        Node cpRoot = new Node(root.val);
        
        // 根节点的孩子节点都是深拷贝
        cpRoot.children = new ArrayList<>();
        for (Node child : root.children) {
            cpRoot.children.add(cloneTree(child));
        }
        // 返回整棵树的深拷贝
        return cpRoot;
    }
}
