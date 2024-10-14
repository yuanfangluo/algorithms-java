package Algorithms._1_经典数据结构算法.手把手刷二叉树算法.二叉搜索树特性篇.BST转化累加树;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
public class _538_把二叉搜索树转换为累加树 {
    TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    // 记录累加和
    int sum = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        // 维护累加和
        sum += root.val;
        // 将 BST 转化成累加树
        root.val = sum;
        traverse(root.left);
    }
}
