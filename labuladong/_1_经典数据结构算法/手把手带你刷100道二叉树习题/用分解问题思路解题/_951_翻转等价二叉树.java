package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/flip-equivalent-binary-trees/
public class _951_翻转等价二叉树 {
    // 如何分解这个问题呢？
    // 原问题是两棵二叉树是否是翻转等价的，只要两棵树的根节点能够匹配，那我们就可以去考察这两个根节点的左右子树（共四棵）是否是翻转等价的。

    // 对子树把翻转和不翻转两种情况全都穷举一遍，只要有一种情况能够匹配，就说明整棵树是翻转等价的
    // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // 判断 root1 和 root2 两个节点是否能够匹配
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        
        // 根据函数定义，判断子树是否能够匹配
        // 不翻转、翻转两种情况满足一种即可算是匹配
        return (
                // 不翻转子树
                flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
        ) || (
                // 反转子树
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)
        );
    }
}
