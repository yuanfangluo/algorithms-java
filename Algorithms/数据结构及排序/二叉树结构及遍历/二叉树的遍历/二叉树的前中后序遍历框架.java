package Algorithms.数据结构及排序.二叉树结构及遍历.二叉树的遍历;

import Algorithms.Base.TreeNode;

public class 二叉树的前中后序遍历框架 {
    // 递归遍历（DFS）
    
    // 前序位置的代码会在进入节点时执行；
    // 中序位置的代码会在左子树遍历完成后，遍历右子树之前执行；
    // 后序位置的代码会在左右子树遍历完成后执行
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
