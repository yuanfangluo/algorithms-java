package Algorithms._0_核心框架汇总.学习算法和刷题的框架思维.习题;

import Algorithms.Base.TreeNode;

public class _124_求二叉树中最大路径和 {
    int res = Integer.MIN_VALUE;

    int oneSideMax(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序位置
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
