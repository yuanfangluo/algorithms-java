package Algorithms.数据结构基础.手写标准库中的二叉树结构;

import Algorithms.Base.TreeNode;

public class 二叉树的前中后序遍历框架 {
    
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历代码位置
        traverse(root.left);
        // 中序遍历代码位置
        traverse(root.right);
        // 后序遍历代码位置
    }
}
