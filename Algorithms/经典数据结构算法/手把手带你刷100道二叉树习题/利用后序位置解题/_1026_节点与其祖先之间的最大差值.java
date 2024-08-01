package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/
public class _1026_节点与其祖先之间的最大差值 {
    // 每个节点需要知道左右子树的最小值和最大值，然后就能算出「以自己为祖先」的最大差值。
    // 每个节点都知道以自己为祖先的最大差值，那么所有这些差值中最大的那个就是整棵树的最大差值，这个取最大值的过程需要在后序遍历的位置进行
    class Solution {
        int res = 0;

        public int maxAncestorDiff(TreeNode root) {
            getMinMax(root);
            return res;
        }

        // 定义：输入一棵二叉树，返回该二叉树中节点的最小值和最大值，
        // 第一个元素是最小值，第二个值是最大值
        int[] getMinMax(TreeNode root) {
            if (root == null) {
                return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
            }

            int[] leftMinMax = getMinMax(root.left);
            int[] rightMinMax = getMinMax(root.right);

            // 以 root 为根的这棵树的最大值和最小值可以通过左右子树的最大最小值推导出来
            int rootMin = min(root.val, leftMinMax[0], rightMinMax[0]);
            int rootMax = max(root.val, leftMinMax[1], rightMinMax[1]);
            // 在后序位置顺便判断所有差值的最大值
            res = max(res, rootMax - root.val, root.val - rootMin);

            return new int[] { rootMin, rootMax };
        }

        int min(int a, int b, int c) {
            return Math.min(Math.min(a, b), c);
        }

        int max(int a, int b, int c) {
            return Math.max(Math.max(a, b), c);
        }
    }

    class Solution2 {

        private int maxAbs = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root, root.val, root.val);
            return maxAbs;
        }

        public void dfs(TreeNode node, int min, int max) {
            if (node == null)
                return;
            min = Math.min(min, node.val);
            max = Math.max(max, node.val);
            dfs(node.left, min, max);
            dfs(node.right, min, max);
            maxAbs = Math.max(maxAbs, Math.max(Math.abs(node.val - min), Math.abs(node.val - max)));
        }
    }

}
