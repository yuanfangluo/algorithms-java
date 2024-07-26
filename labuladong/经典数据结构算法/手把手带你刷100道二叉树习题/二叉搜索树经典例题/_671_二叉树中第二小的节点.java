package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/second-minimum-node-in-a-binary-tree/
public class _671_二叉树中第二小的节点 {
    class Solution {
        // 定义：输入一棵二叉树，返回这棵二叉树中第二小的节点值
        public int findSecondMinimumValue(TreeNode root) {

            if (root.left == null && root.right == null) {
                return -1;
            }

            // 左右子节点中不同于 root.val 的那个值可能是第二小的值
            int left = root.left.val, right = root.right.val;

            // 如果左右子节点都等于 root.val，则去左右子树递归寻找第二小的值
            if (root.val == root.left.val) {
                left = findSecondMinimumValue(root.left);
            }

            if (root.val == root.right.val) {
                right = findSecondMinimumValue(root.right);
            }

            if (left == -1) {
                return right;
            }
            
            if (right == -1) {
                return left;
            }

            // 如果左右子树都找到一个第二小的值，更小的那个是整棵树的第二小元素
            return Math.min(left, right);
        }
    }
}
