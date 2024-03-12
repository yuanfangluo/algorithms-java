package LeetCode._3_二叉树;

import LeetCode.Base.TreeNode;

/*
* https://leetcode.cn/problems/maximum-depth-of-binary-tree/
*
* */
public class _104_二叉树的最大深度 {

    int depth = 0;
    int res = 0;

    // 思路一：遍历一遍二叉树得到答案，回溯算法思路
    // 这个解法应该很好理解，但为什么需要在前序位置增加 depth，在后序位置减小 depth？
    // 因为前面说了，前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth 记录当前递归到的节点深度，
    // 你把 traverse 理解成在二叉树上游走的一个指针，所以当然要这样维护。
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        depth--;
    }

    // 思路二：分解问题得到答案，动态规划思路
    // 函数定义：输入一个节点，返回以该节点为根的二叉树的最大深度
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);

        // 根据左右子树的最大深度推出原二叉树的最大深度
        // 再加上根节点自己
        return 1 + Math.max(leftMax, rightMax);
    }

}
