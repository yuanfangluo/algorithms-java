package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/split-bst/
public class _776_拆分二叉搜索树 {
    class Solution {
        // 定义：输入一棵 BST 和一个 target，返回两棵 BST 的根节点，
        // 第一棵所有节点都小于等于 target，第二棵所有节点都大于 target
        public TreeNode[] splitBST(TreeNode root, int target) {
            if (root == null) {
                return new TreeNode[2];
            }
            
            TreeNode[] res = new TreeNode[2];
    
            if (root.val <= target) {
                // root 必然是第一棵 BST 的根节点
                res[0] = root;
                // 第二棵 BST 的根节点需要去右子树算
                TreeNode[] right = splitBST(root.right, target);
                res[1] = right[1];
                // 保证 root 的右子树都是小于 target 的
                root.right = right[0];
            } else {
                // root 必然是第二棵 BST 的根节点
                res[1] = root;
                // 第一棵 BST 的根节点需要去左子树寻找
                TreeNode[] left = splitBST(root.left, target);
                res[0] = left[0];
                // 保证 root 的左子树都是大于 target 的
                root.left = left[1];
            }
            return res;
        }
    }
}
