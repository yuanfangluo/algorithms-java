package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-maximum-path-sum/
public class _124_二叉树中的最大路径和 {
    class Solution1 {
        public int maxPathSum(TreeNode root) {
            value(root);
            return sum;
        }

        private int sum = Integer.MIN_VALUE;

        private int value(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int lv = Math.max(value(node.left), 0);
            int rv = Math.max(value(node.right), 0);
            sum = Math.max(sum, lv + node.val + rv);
            return node.val + Math.max(lv, rv);
        }
    }

    class Solution2 {
        int res = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 计算单边路径和时顺便计算最大路径和
            oneSideMax(root);
            return res;
        }

        // 定义：计算从根节点 root 为起点的最大单边路径和
        int oneSideMax(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 递归计算左右子树的最大单边路径和
            // 如果子树路径和为负则应当置0表示最大路径和不包含子树
            int leftMaxSum = Math.max(0, oneSideMax(root.left));
            int rightMaxSum = Math.max(0, oneSideMax(root.right));
            // 后序遍历位置，顺便更新最大路径和
            int pathMaxSum = root.val + leftMaxSum + rightMaxSum;
            res = Math.max(res, pathMaxSum);
            // 实现函数定义，左右子树的最大单边路径和加上根节点的值
            // 就是从根节点 root 为起点的最大单边路径和
            return Math.max(leftMaxSum, rightMaxSum) + root.val;
        }
    }
}
