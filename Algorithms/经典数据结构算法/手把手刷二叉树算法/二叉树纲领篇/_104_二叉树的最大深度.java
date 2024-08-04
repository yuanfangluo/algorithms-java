package Algorithms.经典数据结构算法.手把手刷二叉树算法.二叉树纲领篇;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/maximum-depth-of-binary-tree/

public class _104_二叉树的最大深度 {
    // 思路一：遍历一遍二叉树得到答案
    class Solution1 {
        // 记录当前递归到的节点深度
        int depth = 0;
        // 记录最大深度
        int res = 0;

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
    }

    // 思路二：分解问题得到答案
    class Solution2 {
        // 函数定义：输入一个节点，返回以该节点为根的二叉树的最大深度
        public int maxDepth(TreeNode root) {
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
}
