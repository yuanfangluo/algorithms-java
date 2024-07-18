package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/longest-univalue-path/
public class _687_最长同值路径 {
    class Solution {
        int res = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 在后序遍历的位置更新 res
            maxLen(root, root.val);
            return res;
        }

        // 定义：计算以 root 为根的这棵二叉树中，从 root 开始值为 parentVal 的最长树枝长度
        private int maxLen(TreeNode root, int parentVal) {
            if (root == null) {
                return 0;
            }

            // 利用函数定义，计算左右子树值为 root.val 的最长树枝长度
            int leftLen = maxLen(root.left, root.val);
            int rightLen = maxLen(root.right, root.val);

            // 后序遍历位置顺便更新全局变量
            // 同值路径就是左右同值树枝长度之和
            res = Math.max(res, leftLen + rightLen);

            // 如果 root 本身和上级值不同，那么整棵子树都不可能有同值树枝
            if (root.val != parentVal) {
                return 0;
            }

            return 1 + Math.max(leftLen, rightLen);
        }
    }

    class Solution2 {
        private int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null)
                return -1;
            int l_len = dfs(node.left) + 1;
            int r_len = dfs(node.right) + 1;
            if (node.left != null && node.val != node.left.val)
                l_len = 0;
            if (node.right != null && node.val != node.right.val)
                r_len = 0;
            ans = Math.max(ans, l_len + r_len);
            return Math.max(l_len, r_len);
        }
    }
}
