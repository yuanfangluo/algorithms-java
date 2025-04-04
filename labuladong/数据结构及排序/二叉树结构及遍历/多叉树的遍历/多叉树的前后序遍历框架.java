package labuladong.数据结构及排序.二叉树结构及遍历.多叉树的遍历;

import labuladong.Base.Node;

public class 多叉树的前后序遍历框架 {
    // DFS
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
