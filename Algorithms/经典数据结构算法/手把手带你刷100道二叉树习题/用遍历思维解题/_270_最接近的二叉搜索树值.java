package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/closest-binary-search-tree-value/
public class _270_最接近的二叉搜索树值 {

    int res = 0;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        traverse(root, target);
        return res;
    }

    void traverse(TreeNode root, double target) {
        if (root == null) {
            return;
        }

        if (Math.abs(root.val - target) < Math.abs(res - target)) {
            res = root.val;
            return;
        }

        if (root.val < target) {
            traverse(root.right, target);
        } else {
            traverse(root.left, target);
        }
    }

    // 如果有多个答案，返回最小的那个
    class Solution {
        int res = Integer.MAX_VALUE;

        public int closestValue(TreeNode root, double target) {
            traverse(root, target);
            return res;
        }

        // 遍历函数，在 BST 中搜索 target
        // 我们在中序位置写 if 判断逻辑，这样就可以从小到大执行，保证最终结果是值最小的
        void traverse(TreeNode root, double target) {
            if (root == null) {
                return;
            }
            // 根据 target 和 root.val 的相对大小决定去左右子树搜索
            if (root.val < target) { // 去右子树
                // 中序位置（左子树遍历结束，准备遍历右子树时）
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
                // 右边
                traverse(root.right, target);
            } else {
                traverse(root.left, target);
                // 中序位置（左子树遍历结束，准备遍历右子树时）
                if (Math.abs(root.val - target) < Math.abs(res - target)) {
                    res = root.val;
                }
            }
        }
    }
}
