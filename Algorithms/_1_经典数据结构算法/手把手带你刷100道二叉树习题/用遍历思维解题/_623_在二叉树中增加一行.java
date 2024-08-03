package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/add-one-row-to-tree/
public class _623_在二叉树中增加一行 {
    private int targetVal, targetDepth;

    // 根据题目，至少有一个根节点
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        targetVal = val;
        targetDepth = depth;
        // 如果插到第一行
        if (targetDepth == 1) {
            TreeNode newRoot = new TreeNode(targetVal);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root);
        return root;
    }

    private int curDepth = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        curDepth++;
        if (curDepth == targetDepth - 1) {
            // 进行插入
            TreeNode newLeft = new TreeNode(targetVal);
            TreeNode newRight = new TreeNode(targetVal);
            newLeft.left = root.left;
            newRight.right = root.right;
            root.left = newLeft;
            root.right = newRight;
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        curDepth--;
    }
}
