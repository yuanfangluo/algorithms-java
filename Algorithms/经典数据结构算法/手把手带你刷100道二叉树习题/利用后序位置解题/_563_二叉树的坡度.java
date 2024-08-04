package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-tilt/
public class _563_二叉树的坡度 {
    // 数到坡度：也就是节点的坡度之和
    int globalTilt;

    public int findTilt(TreeNode root) {
        sum(root);
        return globalTilt;
    }

    // 定义：节点之和,求节点之和的时候顺便把坡度求出来，并且累加；
    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        // 后序位置
        // 节点之和
        int sum = leftSum + rightSum + root.val;
        // 坡度
        int tilt = Math.abs(leftSum - rightSum);
        // 记录全局坡度
        globalTilt += tilt;
        // 记录全局坡度
        return sum;
    }
}
