package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/path-sum/
public class _112_路径总和 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, targetSum);
        }

        private boolean dfs(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }

            if (root.left == null && root.right == null) {
                return targetSum == root.val;
            }

            return dfs(root.left, targetSum - root.val) || dfs(root.right, targetSum - root.val);
        }
    }
}
