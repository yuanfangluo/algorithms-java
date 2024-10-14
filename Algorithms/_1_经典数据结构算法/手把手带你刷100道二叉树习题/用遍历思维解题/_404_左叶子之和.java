package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/sum-of-left-leaves/
public class _404_左叶子之和 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null & root.left.right == null) {
            sum += root.left.val;
        }

        // 递归框架
        traverse(root.left);
        traverse(root.right);
    }
}
