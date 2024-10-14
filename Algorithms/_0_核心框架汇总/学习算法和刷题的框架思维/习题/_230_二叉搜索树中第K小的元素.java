package Algorithms._0_核心框架汇总.学习算法和刷题的框架思维.习题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
public class _230_二叉搜索树中第K小的元素 {
    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}
