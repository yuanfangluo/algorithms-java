package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/
public class _1372_二叉树中的最长交错路径 {
    // 如果一个从上到下的交错路径的开头是从右到左的，称之为「左交错路径」，反之成为「右交错路径」。
    // 这样的话，一个节点 x 能够产生的交错路径就能分解到左右子树：
    // 1、x 的左子树的「右交错路径」+ 节点 x = x 的「左交错路径」
    // 2、x 的右子树的「左交错路径」+ 节点 x = x 的「右交错路径」
    // 比较 x 的左右交错路径，即可算出以 x 开头的最长交错路径。
    // 对二叉树上的所有节点计算交错路径长度，即可得到最长的交错路径长度。
    // 所以我们定义一个 getPathLen 函数计算并返回一个节点的左右交错路径长度，然后在后序位置上更新全局最大值。

    class Solution {
        int res = 0;

        public int longestZigZag(TreeNode root) {
            getPathLen(root);
            return res;
        }

        // 输入二叉树的根节点 root，返回两个值
        // 第一个是从 root 开始向左走的最长交错路径长度，
        // 第一个是从 root 开始向右走的最长交错路径长度
        // 注意返回值是一个长度为 2 的数组
        // 因为我们需要比较「左交错路径」和「右交错路径」，所以定义一个长度为 2 的数组
        // 第一个元素代表「左交错路径」的长度，第二个元素代表「右交错路径」的长度
        int[] getPathLen(TreeNode root) {
            if (root == null) {
                return new int[] { -1, -1 };
            }

            // 分别代表左右子树的交错路径长度
            int[] left = getPathLen(root.left);
            int[] right = getPathLen(root.right);

            // 后序位置，根据左右子树的交错路径长度推算根节点的交错路径长度
            // 节点的左交错路径的长度是根节点的右子树的交错路径长度 + 1
            int rootLeftPath = left[1] + 1;
            // 节点的右交错路径的长度是根节点的左子树的交错路径长度 + 1
            int rootRightPath = right[0] + 1;

            // 更新全局最大值
            res = Math.max(res, Math.max(rootLeftPath, rootRightPath));

            return new int[] { rootLeftPath, rootRightPath };
        }
    }

    class Solution2 {
        private int res = 0;

        public int longestZigZag(TreeNode root) {
            dfs(root, 0, 0);
            return res;
        }

        private void dfs(TreeNode node, int left, int right) {
            res = Math.max(res, Math.max(left, right));
            if (node.left != null)
                dfs(node.left, right + 1, 0);
            if (node.right != null)
                dfs(node.right, 0, left + 1);
        }
    }

}
