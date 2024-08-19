package Algorithms.核心框架汇总.学习算法和刷题的框架思维.习题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/
public class _124_二叉树中的最大路径和 {
    int res = Integer.MIN_VALUE;

    // 后序遍历
    public int maxPathSum(TreeNode root) {
        oneSideMax(root);
        return res;
    }

    // 返回单条边的最大路径和，只能是左子树或者右子树
    int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归遍历左右子树
        // 注意：这里的返回值是单条边的最大路径和，只能是左子树或者右子树
        // 所以，不能直接返回 root.val + Math.max(left, right)
        // 因为，左子树或者右子树有可能是负值，所以不能直接返回 root.val + Math.max(left, right)
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序位置
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
