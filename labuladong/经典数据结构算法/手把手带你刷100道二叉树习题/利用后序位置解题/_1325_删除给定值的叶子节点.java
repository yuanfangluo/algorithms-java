package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.利用后序位置解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/delete-leaves-with-a-given-value/
public class _1325_删除给定值的叶子节点 {
    // 一个节点要在后序位置接收左右子树的返回值，才能知道自己的叶子节点是否都被删掉了，以此判断自己是不是变成了叶子节点。
    class Solution {
        public TreeNode removeLeafNodes(TreeNode root, int target) {
            if (root == null) return null;
            // 如果左右子节点需要被删除，先递归删除它们
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right, target);
            
            // 后序遍历位置，此时节点 root 直到自己是否需要被删除
            if (root.val == target && root.left == null && root.right == null) {
                return null;
            }
            return root;
        }
    }
}
