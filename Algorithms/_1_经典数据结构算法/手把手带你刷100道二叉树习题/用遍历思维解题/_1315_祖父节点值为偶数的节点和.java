package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/sum-of-nodes-with-even-valued-grandparent/
public class _1315_祖父节点值为偶数的节点和 {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        traverse(root);
        return sum;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if ((root.val & 1) == 0) { // 偶数
            // 累加左子树孙子节点的值
            if (root.left != null) {
                if (root.left.left != null) {
                    sum += root.left.left.val;
                }

                if (root.left.right != null) {
                    sum += root.left.right.val;
                }
            }

            if (root.right != null) {
                if (root.right.left != null) {
                    sum += root.right.left.val;
                }

                if (root.right.right != null) {
                    sum += root.right.right.val;
                }
            }
        }

        // 二叉树的遍历框架
        traverse(root.left);
        traverse(root.right);
    }

    class Solution {
        int sum = 0;

        public int sumEvenGrandparent(TreeNode root) {
            dfs(root, null, null);
            return sum;
        }

        private void dfs(TreeNode root, TreeNode g, TreeNode f) {
            if (root == null) {
                return;
            }
            if (g != null && g.val % 2 == 0) {
                sum += root.val;
            }

            dfs(root.left, f, root);
            dfs(root.right, f, root);
        }
    }
}
