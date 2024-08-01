package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-pruning/
public class _814_二叉树剪枝 {
    class Solution {
        // 定义：输入一棵二叉树，返回的二叉树叶子节点都是 1
        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            // 二叉树递归框架
            root.left = pruneTree(root.left);
            root.right = pruneTree(root.right);

            // 后序遍历位置，判断自己是否是值为 0 的叶子节点
            if (root.val == 0 && root.left == null && root.right == null) {
                // 返回值会被父节点接收，相当于把自己删掉了
                return null;
            }
            // 如果不是，正常返回
            return root;
        }
    }
}
