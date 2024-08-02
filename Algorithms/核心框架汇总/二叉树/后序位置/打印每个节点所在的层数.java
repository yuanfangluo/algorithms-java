package Algorithms.经典数据结构算法.手把手刷二叉树算法.二叉树纲领篇;

import Algorithms.Base.TreeNode;

public class 打印每个节点所在的层数 {

    void printNodeLevel(TreeNode root) {
        // 这样调用
        traverse(root, 1);
    }

    // 二叉树遍历函数
    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.printf("节点：" + root);
        System.out.printf("在第 %d 层", level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}
