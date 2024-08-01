package Algorithms.经典暴力搜索算法.DFS和回溯算法.岛屿问题;

import Algorithms.Base.TreeNode;

public class 二叉树遍历框架 {
    // 二叉树遍历框架
    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }
}
