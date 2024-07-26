package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/increasing-order-search-tree/
public class _897_递增顺序搜索树 {
    class Solution {
        TreeNode pre;
        TreeNode head;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }

            increasingBST(root.left);

            if (pre == null) {
                pre = root;
                head = root;
            } else {
                pre.right = root;
                pre = root;
            }

            root.left = null;

            increasingBST(root.right);
            return head;
        }
    }
}
