package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/range-sum-of-bst/
public class _938_二叉搜索树的范围和 {
    class Solution {
        int sum = 0;

        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null)
                return 0;
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
            return sum;
        }
    }

    class Solution2 {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            }
            if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            }
            return rangeSumBST(root.left, low, high) + root.val + rangeSumBST(root.right, low, high);
        }
    }
}
