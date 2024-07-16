package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.同时运用两种思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
public class _1430_判断给定的序列是否是二叉树从根到叶的路径 {
    class Solution {
        public boolean isValidSequence(TreeNode root, int[] arr) {
            return dfs(root, arr, 0);
        }

        // 从 root 开始，判断 arr[i..] 是否合法
        // arr[i..] 是从 i 开始的后缀
        // 注意，这里 i 是从 0 开始的
        // 所以，这里的 arr[i] 是从 arr 下标 i 开始的后缀
        private boolean dfs(TreeNode root, int[] arr, int i) {
            if (root == null) {
                return false;
            }
            if (i == arr.length - 1) {
                return root.val == arr[i] && root.left == null && root.right == null;
            }
            return root.val == arr[i] && (dfs(root.left, arr, i + 1) || dfs(root.right, arr, i + 1));
        }
    }

}
