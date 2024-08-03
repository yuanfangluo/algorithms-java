package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/merge-two-binary-trees/
public class _617_合并二叉树 {
    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }

            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
            return root;
        }
    }
}
