package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/maximum-average-subtree/
public class _1120_子树的最大平均值 {
    // 首先，你看到题目让你算的结果和子树有关，就知道肯定要用后序位置接收左右子树传回来的信息。
    // 那么我们站在一个节点上，需要知道子树的什么信息，才能计算出以这个节点为根的这棵树的平均值呢？
    // 我们知道，子树的平均值 = 子树的和 / 子树的节点数，所以我们只需要知道子树的和和子树的节点数，就能算出平均值了。
    // 所以我们定义一个 getCountAndSum 函数，输入一棵二叉树，就能返回节点总数和节点之和，然后在后序位置利用这些信息计算全局的最大平均值即可。

    double maxAvg = 0;
    public double maximumAverageSubtree(TreeNode root) {
        getCountAndSum(root);
        return maxAvg;
    }

    // 定义：输入 root，返回以 root 为根的二叉树的节点个数和节点值之和
    int[] getCountAndSum(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        // 先拿到左右子树的节点个数和节点之和
        int[] left = getCountAndSum(root.left);
        int[] right = getCountAndSum(root.right);

        int leftCount = left[0], leftSum = left[1];
        int rightCount = right[0], rightSum = right[1];

        int rootCount = leftCount + rightCount + 1;
        int rootSum = root.val + leftSum + rightSum;

        // 后序位置，计算全局的最大平均值
        maxAvg = Math.max(maxAvg, 1.0 * rootSum / rootCount);

        // 实现函数的定义
        return new int[]{rootCount, rootSum};
    }

}
