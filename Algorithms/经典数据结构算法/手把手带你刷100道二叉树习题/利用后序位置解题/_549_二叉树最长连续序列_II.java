package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence-ii/
public class _549_二叉树最长连续序列_II {

    // 二叉树的最长连续序列 II
    class Solution {
        public int longestConsecutive(TreeNode root) {
            findSequence(root);
            return res;
        }

        // 全局变量记录题目要求的的序列长度
        int res = 0;

        // 定义：输入 root，它输入一个根节点，返回值有两个，
        // 分别是从 root 出发的最长递增和递减序列的长度。
        int[] findSequence(TreeNode root) {
            if (root == null) {
                // base case
                return new int[] { 0, 0 };
            }

            // 利用函数定义，计算出左右子树的递增/递减序列长度
            int[] left = findSequence(root.left);
            int[] right = findSequence(root.right);

            // 后序位置
            // 1. 先处理根节点
            int inc = 1, dec = 1;
            // 2. 如果左子树是递增序列，那么根节点就可以加入到左子树递增序列中
            if (root.left!= null && root.left.val + 1 == root.val) {
                inc = Math.max(inc, left[0] + 1);
            }
            // 3. 如果左子树是递减序列，那么根节点就可以加入到左子树递减序列中
            if (root.left!= null && root.left.val - 1 == root.val) {
                dec = Math.max(dec, left[1] + 1);
            }
            // 4. 如果右子树是递增序列，那么根节点就可以加入到右子树递增序列中
            if (root.right!= null && root.right.val + 1 == root.val) {
                inc = Math.max(inc, right[0] + 1);
            }
            // 5. 如果右子树是递减序列，那么根节点就可以加入到右子树递减序列中
            if (root.right!= null && root.right.val - 1 == root.val) {
                dec = Math.max(dec, right[1] + 1);
            }
            // 6. 到这里为止，已经知道了以 root 为根的树的最长递增和递减序列的长度
            // 记录最长连续序列的长度
            res = Math.max(res, inc + dec - 1);

            // 7. 返回以 root 为根的树的最长递增和递减序列的长度
            return new int[] { inc, dec };
        }
    }


    // 你需要知道左右子树的最长「递增序列」和最长「递减序列」，你可以通过子树的递增/递减序列，加上根节点，就形成了题目要求的最长「连续序列」。
    // 我们可以定义一个函数 findSequence，它输入一个根节点，返回值有两个，分别是从这个根节点出发的最长递增/递减序列的长度
    class Solution2 {
        public int longestConsecutive(TreeNode root) {
            findSequence(root);
            return res;
        }

        // 全局变量记录题目要求的的序列长度
        int res = 0;

        // 定义：输入 root，它输入一个根节点，返回值有两个，
        // 分别是从 root 出发的最长递增和递减序列的长度。
        int[] findSequence(TreeNode root) {
            if (root == null) {
                // base case
                return new int[] { 0, 0 };
            }

            // 利用函数定义，计算出左右子树的递增/递减序列长度
            int[] left = findSequence(root.left);
            int[] right = findSequence(root.right);

            // 后序位置，根据左右子树的递增/递减序列长度
            // 推导以 root 为根的树的递增/递减序列长度
            int leftIncrLen = left[0], leftDecrLen = left[1];
            int rightIncrLen = right[0], rightDecrLen = right[1];
            int rootIncrLen = 1, rootDecrLen = 1;

            if (root.left != null) {
                if (root.left.val - 1 == root.val) {
                    rootIncrLen += leftIncrLen;
                } else if (root.left.val + 1 == root.val) {
                    rootDecrLen += leftDecrLen;
                }
            }

            if (root.right != null) {
                if (root.right.val - 1 == root.val) {
                    rootIncrLen = Math.max(rootIncrLen, rightIncrLen + 1);
                }
                if (root.right.val + 1 == root.val) {
                    rootDecrLen = Math.max(rootDecrLen, rightDecrLen + 1);
                }
            }

            // 子树递增序列 + 根节点 + 子树递减序列 = 题目要求的序列
            // 因为 rootIncrLen 和 rootDecrLen 中都算上了 root 节点，所以减一
            res = Math.max(res, rootIncrLen + rootDecrLen - 1);
            // 实现函数的定义
            return new int[] { rootIncrLen, rootDecrLen };
        }
    }
}
