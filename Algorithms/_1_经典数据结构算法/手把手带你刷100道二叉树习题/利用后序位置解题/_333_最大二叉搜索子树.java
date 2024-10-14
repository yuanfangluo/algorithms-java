package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/largest-bst-subtree/
public class _333_最大二叉搜索子树 {
    // 这要根据 BST 的特性：
    // 左子树的所有节点都要比根节点小，右子树的所有节点都要比根节点大，
    // 所以可以根据左子树的最大值和右子树的最小值来判断 BST 的合法性。
    // 同时，题目让计算最大的 BST 的节点个数，所以子树还应该回传节点总数。
    class Solution {
        public int largestBSTSubtree(TreeNode root) {
            findBST(root);
            return res;
        }

        int res = 0;
        // 定义：输入一棵二叉树，如果这棵二叉树不是 BST，则返回 null，
        // 如果这棵树是 BST，则返回三个数：
        // 第一个数是这棵 BST 中的最小值，
        // 第二个数是这棵 BST 中的最大值，
        // 第三个数是这棵 BST 的节点总数
        int[] findBST(TreeNode root) {
            if (root == null) {
                // 空指针也是 BST
                return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
            }
            // 后序位置，先递归左右子树
            // 注意：这里的逻辑顺序是：先递归左子树，再递归右子树，最后处理根节点
            // 这样才能保证左子树的所有节点都比根节点小，右子树的所有节点都比根节点大

            int[] left = findBST(root.left);
            int[] right = findBST(root.right);

            // 后序位置，根据左右子树的情况推算以 root 为根的二叉树的情况
            if (left == null || right == null) {
                // 如果左右子树如果有一个不是 BST，
                // 则以 root 为根的二叉树也必然不是 BST
                return null;
            }

            // 判断以 root 为根的二叉树是否是 BST
            int leftMin = left[0], leftMax = left[1], leftCount = left[2];
            int rightMin = right[0], rightMax = right[1], rightCount = right[2];

            if (root.val > leftMax && root.val < rightMin) {
                // 以 root 为根的二叉树是 BST
                int rootMin = Math.min(leftMin, root.val);
                int rootMax = Math.max(rightMax, root.val);
                int rootCount = leftCount + rightCount + 1;
                // 更新全局变量，记录 BST 的最大节点个数
                res = Math.max(res, rootCount);
                // 履行函数的定义
                return new int[] { rootMin, rootMax, rootCount };
            }

            return null;
        }
    }

    class Solution2 {
        public int largestBSTSubtree(TreeNode root) {
            return dfs(root)[0];
        }

        // 后序遍历
        int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[] { 0, Integer.MAX_VALUE, Integer.MIN_VALUE };
            }

            int[] left = dfs(root.left);
            int[] right = dfs(root.right);

            if (left[1] < root.val && root.val < right[2]) {
                return new int[] { left[0] + right[0] + 1, Math.min(root.val, left[2]), Math.max(root.val, right[1]) };
            }

            return new int[] { Math.max(left[0], right[0]), Integer.MIN_VALUE, Integer.MAX_VALUE };
        }
    }

}
