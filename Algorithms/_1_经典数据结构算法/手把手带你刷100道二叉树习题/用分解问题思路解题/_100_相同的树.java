package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/same-tree/
public class _100_相同的树 {
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

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return compare(p,q);
        }
    
        private boolean compare(TreeNode p, TreeNode q) {
            if (p == null && q != null) return false;
            if (p != null && q == null) return false;
            if (p == null && q == null) return true;
            if (p.val != q.val) return false;
            Boolean left = compare(p.left, q.left);
            Boolean right = compare(p.right, q.right);
            return left && right;
        }
    
    }
}
