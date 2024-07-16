package labuladong.手把手刷数据结构.手把手刷二叉树算法.二叉搜索树基操篇.在BST中搜索元素;

import labuladong.Base.TreeNode;
// https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        
        return root;
    }
}
