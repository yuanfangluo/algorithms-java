package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
public class _1022_从根到叶的二进制数之和 {

    public static void main(String[] args) {
        // 假设我要将二进制的0或者1
        // 初始值是0
        // 1
        System.out.println(0 << 1 | 1); // 0b1
        // 0
        System.out.println(1 << 1 | 0); // 0b10 = 2
        // 0
        System.out.println(0b10 << 1 | 0); // 0b100 = 4
        int path = 0;
        // 1, 0, 0
        int[] nums = new int[] { 1, 0, 0 };
        for (int i : nums) {
            path = (path << 1) | i;
        }
        System.out.println(path);
    }

    // 用 path 变量维护每一条从根节点到叶子节点的路径形成的二进制数，到了叶子节点之后将这条路径的二进制数累加到 res 中即可。
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    int path = 0;
    int res = 0;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            // 叶子节点

            res += path << 1 | root.val;
            return;
        }

        // 前序位置
        path = path << 1 | root.val;

        traverse(root.left);
        traverse(root.right);
        // 后序位置
        path = path >> 1;
    }
}
