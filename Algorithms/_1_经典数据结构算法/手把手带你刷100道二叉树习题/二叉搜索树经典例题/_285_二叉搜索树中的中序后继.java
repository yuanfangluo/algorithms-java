package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/inorder-successor-in-bst/
public class _285_二叉搜索树中的中序后继 {
    // 显然比 p 大的最小元素就是 p.right 子树中最左侧的那个元素。
    // 那如果 p.right 为空怎么办？此时比 p 大的最小元素就是 p 的父节点

    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }
            
            TreeNode successor = null;
            if (root.val > p.val) {
                successor = inorderSuccessor(root.left, p);
                // 父节点收到 null 的话说明自己是 successor
                if (successor == null) {
                    successor = root;
                }
            }
            if (root.val < p.val) {
                successor = inorderSuccessor(root.right, p);
            }
            if (root.val == p.val) {
                // 我是目标节点，我的 successor 是右子树的最小节点
                successor = getMinNode(root.right);
            }
            return successor;
        }

        // BST 中最左侧的节点就是最小节点
        private TreeNode getMinNode(TreeNode p) {
            while (p != null && p.left != null) {
                p = p.left;
            }
            return p;
        }

        // 精简代码装逼版解法
        public TreeNode inorderSuccessor_Opt(TreeNode root, TreeNode p) {
            if (root == null) {
                return null;
            }

            if (root.val > p.val) {
                TreeNode successor = inorderSuccessor(root.left, p);
                return successor == null ? root : successor;
            }
            // root.val == p.val || root.val < p.val
            return inorderSuccessor(root.right, p);
        }
    }
}
