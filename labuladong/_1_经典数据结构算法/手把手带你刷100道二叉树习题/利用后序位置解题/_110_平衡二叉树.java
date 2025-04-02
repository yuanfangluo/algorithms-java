package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/balanced-binary-tree/
public class _110_平衡二叉树 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getDepth(root) != -1;
        }

        public int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = getDepth(root.left);
            if (leftDepth == -1) {
                return -1;
            }

            int rightDepth = getDepth(root.right);
            if (rightDepth == -1) {
                return -1;
            }

            if (Math.abs(leftDepth - rightDepth) > 1) {
                return -1;
            }

            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else {
                return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left)
                        && isBalanced(root.right);
            }
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            } else {
                return Math.max(height(root.left), height(root.right)) + 1;
            }
        }
    }
}
