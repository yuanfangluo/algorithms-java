package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/subtree-of-another-tree/
public class _572_另一棵树的子树 {
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        // 判断以 root 为根的二叉树是否和 subRoot 相同
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // 去左右子树中判断是否有和 subRoot 相同的子树
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 判断一对节点是否相同
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        // 判断其他节点是否相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
