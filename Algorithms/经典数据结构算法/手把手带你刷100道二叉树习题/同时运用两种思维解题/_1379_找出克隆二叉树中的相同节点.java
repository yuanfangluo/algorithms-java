package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
public class _1379_找出克隆二叉树中的相同节点 {
    class Solution {
        public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
            if (original == null) {
                return null;
            }
            if (original == target) {
                return cloned;
            }

            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }

            TreeNode right = getTargetCopy(original.right, cloned.right, target);
            return right;
        }
    }
}
