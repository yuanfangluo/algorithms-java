package Algorithms.经典数据结构算法.手把手刷二叉树算法.Git原理之最近公共祖先;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class _236_二叉树的最近公共祖先 {

    // 如果一个节点能够在它的左右子树中分别找到 p 和 q，则该节点为 LCA 节点。
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }
    
    // 在二叉树中寻找 val1 和 val2 的最近公共祖先节点
    TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }

        // 前序位置
        if (root.val == val1 || root.val == val2) {
            // 如果遇到目标值，直接返回
            // 因为题目说了 p 和 q 一定存在于二叉树中(这点很重要），所以即便我们遇到 q 就直接返回，根本没遍历到 p，也依然可以断定 p 在 q 底下，q 就是 LCA 节点。
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);
        
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }
        return left != null ? left : right;
    }
}
