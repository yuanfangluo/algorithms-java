package Algorithms._1_经典数据结构算法.手把手刷二叉树算法.Git原理之最近公共祖先;

import java.util.HashSet;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv/
public class _1676_二叉树的最近公共祖先_IV {

    // 依然给你输入一棵不含重复值的二叉树，但这次不是给你输入 p 和 q 两个节点了，而是给你输入一个包含若干节点的列表
    // nodes（这些节点都存在于二叉树中），让你算这些节点的最近公共祖先。

    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // 将列表转化成哈希集合，便于判断元素是否存在
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }

    // 在二叉树中寻找 values 的最近公共祖先节点
    TreeNode find(TreeNode root, HashSet<Integer> values) {
        if (root == null) {
            return null;
        }
        
        // 前序位置
        if (values.contains(root.val)) {
            return root;
        }

        TreeNode left = find(root.left, values);
        TreeNode right = find(root.right, values);
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && right != null) {
            // 当前节点是 LCA 节点
            return root;
        }

        return left != null ? left : right;
    }

}
