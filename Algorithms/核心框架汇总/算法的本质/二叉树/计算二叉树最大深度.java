package Algorithms.核心框架汇总.算法的本质.二叉树;

import Algorithms.Base.TreeNode;

public class 计算二叉树最大深度 {
    // 思路一：遍历一遍得到结果
    class Solution1 {
        // 记录最大深度
        int res = 0;
        int depth = 0;

        // 主函数
        int maxDepth(TreeNode root) {
            traverse(root);
            return res;
        }

        // 二叉树遍历框架
        void traverse(TreeNode root) {
            if (root == null) {
                // 到达叶子节点
                res = Math.max(res, depth);
                return;
            }
            // 前序遍历位置
            depth++;
            traverse(root.left);
            traverse(root.right);
            // 后序遍历位置
            depth--;
        }
    }

    // 分解问题得到结果
    class Solution2 {
        int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            int res = Math.max(leftMaxDepth, rightMaxDepth) + 1;
            return res;
        }
    }
}
