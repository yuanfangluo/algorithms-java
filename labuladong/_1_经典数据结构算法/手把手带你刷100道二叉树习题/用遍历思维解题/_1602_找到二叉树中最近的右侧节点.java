package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-nearest-right-node-in-binary-tree/
public class _1602_找到二叉树中最近的右侧节点 {

    // 这道题的直接思路是用 BFS 层序遍历算法，肯定可以找到节点 u 的相邻节点。
    // 如果你熟悉二叉树的前中后序遍历的顺序，就知道前序遍历也可以找到 u 的相邻节点：
    // 先找到 u 的层数 targetDepth，然后再次走到 targetDepth 时遇到的就是 u 的相邻节点。

    TreeNode res = null;
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        traverse(root, 0, u.val);
        return res;
    }
    int targetDepth = -1;
    void traverse(TreeNode root, int depth, int targetVal) {
        if (root == null || res != null) {
            return;
        }

        if (targetVal == root.val) {
            // 找到目标层数
            targetDepth = depth;
        } else if (depth == targetDepth) {
            // 找到了下一个当前层数的节点
            res = root;
            return;
        }

        // 二叉树遍历框架
        traverse(root.left, depth + 1, targetVal);
        traverse(root.right, depth + 1, targetVal);
    }
}
