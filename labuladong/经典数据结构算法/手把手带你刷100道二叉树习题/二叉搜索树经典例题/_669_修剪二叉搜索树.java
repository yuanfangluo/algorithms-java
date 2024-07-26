package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/trim-a-binary-search-tree/
public class _669_修剪二叉搜索树 {
    // 分解问题
    // 如果一个节点的值没有落在 [lo, hi] 中，有两种情况：
    // 1、root.val < lo，这种情况下 root 节点本身和 root 的左子树全都是小于 lo 的，都需要被剪掉。
    // 2、root.val > hi，这种情况下 root 节点本身和 root 的右子树全都是大于 hi 的，都需要被剪掉

    class Solution {
        // 定义：删除 BST 中小于 low 和大于 high 的所有节点，返回结果 BST
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) return null;
    
            if (root.val < low) {
                // 直接返回 root.right
                // 等于删除 root 以及 root 的左子树
                return trimBST(root.right, low, high);
            }

            if (root.val > high) {
                // 直接返回 root.left
                // 等于删除 root 以及 root 的右子树
                return trimBST(root.left, low, high);
            }
    
            // 闭区间 [lo, hi] 内的节点什么都不做
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
    
            return root;
        }
    }

}
