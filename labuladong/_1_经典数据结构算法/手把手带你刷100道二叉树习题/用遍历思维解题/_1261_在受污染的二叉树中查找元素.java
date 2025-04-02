package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.HashSet;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/
public class _1261_在受污染的二叉树中查找元素 {
    class Solution {
        public void FindElements(TreeNode root) {
            // 还原二叉树中的值
            traverse(root, 0);
        }

        // 帮助 find 函数快速判断
        HashSet<Integer> values = new HashSet<>();

        // 二叉树遍历函数
        void traverse(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            root.val = val;
            values.add(val);

            traverse(root.left, 2 * val + 1);
            traverse(root.right, 2 * val + 2);
        }

        public boolean find(int target) {
            return values.contains(target);
        }
    }
}
