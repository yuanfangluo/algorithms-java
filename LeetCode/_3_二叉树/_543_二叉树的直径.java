package LeetCode._3_二叉树;

import LeetCode.Base.TreeNode;

/*
* https://leetcode.cn/problems/diameter-of-binary-tree/
* 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
* */
public class _543_二叉树的直径 {

    // 记录最大直径的长度
    int maxDiameter = 0;

    // 解法一：思路清晰，但是有冗余
    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        traverse(root);
        return maxDiameter;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 对每个节点计算直径
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
        int myDiameter = leftMax + rightMax;

        // 更新全局最大直径
        maxDiameter = Math.max(maxDiameter, myDiameter);

        traverse(root.left);
        traverse(root.right);
    }

    // 计算二叉树的最大深度
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }

    // 换个解法：
    // traverse 遍历每个节点的时候还会调用递归函数 maxDepth，
    // 而 maxDepth 是要遍历子树的所有节点的，所以最坏时间复杂度是 O(N^2)
    // 这就出现了刚才探讨的情况，前序位置无法获取子树信息，所以只能让每个节点调用 maxDepth 函数去算子树的深度。
    // 那如何优化？我们应该把计算「直径」的逻辑放在后序位置，准确说应该是放在 maxDepth 的后序位置，因为 maxDepth 的后序位置是知道左右子树的最大深度的。

    int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }

}
