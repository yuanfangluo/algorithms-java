package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-longest-consecutive-sequence/
public class _298_二叉树最长连续序列 {
    public int longestConsecutive(TreeNode root) {
        traverse(root, 1, Integer.MIN_VALUE);
        return maxLen;
    }

    int maxLen = 0;

    // 遍历二叉树，根据父节点的值判断连续的序列长度
    void traverse(TreeNode root, int len, int parentVal) {
        if (root == null) {
            return;
        }
        if (parentVal + 1 == root.val) {
            len++;
        } else {
            len = 1;
        }
        // 更新最长连续序列的长度
        maxLen = Math.max(maxLen, len);
        // 遍历框架
        traverse(root.left, len, root.val);
        traverse(root.right, len, root.val);
    }
}
