package Algorithms._1_经典数据结构算法.手把手刷二叉树算法.二叉搜索树特性篇.BST转化累加树;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/binary-search-tree-to-greater-sum-tree/
public class _1038_从二叉搜索树到更大和树 {
    TreeNode bstToGst(TreeNode root) {
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
