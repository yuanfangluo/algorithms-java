package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/smallest-string-starting-from-leaf/
public class _988_从叶结点开始的最小字符串 {
    // 用 path 维护递归遍历的路径，到达叶子节点的时候判断字典序最小的路径。

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历过程中的路径
    StringBuilder path = new StringBuilder();
    String res = null;

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 找到叶子结点，比较字典序最小的路径
            // 结果字符串是从叶子向根，所以需要反转
            path.append((char) ('a' + root.val));
            path.reverse();

            String s = path.toString();
            if (res == null || res.compareTo(s) > 0) {
                // 如果字典序更小，则更新 res
                res = s;
            }

            // 恢复，正确维护 path 中的元素
            path.reverse();
            path.deleteCharAt(path.length() - 1);
            return;
        }
        // 前序位置
        path.append((char) ('a' + root.val));

        traverse(root.left);
        traverse(root.right);

        // 后序位置
        path.deleteCharAt(path.length() - 1);
    }
}
