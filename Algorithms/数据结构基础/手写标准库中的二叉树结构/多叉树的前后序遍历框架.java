package Algorithms.数据结构基础.手写标准库中的二叉树结构;

import Algorithms.Base.Node;

public class 多叉树的前后序遍历框架 {
    // N 叉树的遍历框架
    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序位置
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序位置
    }
}
