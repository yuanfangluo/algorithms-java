package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/even-odd-tree/
public class _1609_奇偶树 {
    class Solution1 {
        public boolean isEvenOddTree(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            int level = 1;
            int gradient = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                TreeNode pre = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeFirst();
                    if (level % 2 != node.val % 2 ||
                            (pre != null && (node.val - pre.val) * gradient <= 0)) {
                        return false;
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    pre = node;
                }
                level++;
                gradient *= -1;
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isEvenOddTree(TreeNode root) {
            if (root == null) {
                return true;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // 记录奇偶层数
            boolean even = true;
            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                int sz = q.size();
                // 记录前一个节点，便于判断是否递增/递减
                int prev = even ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    if (even) {
                        // 偶数层
                        if (prev >= cur.val || (cur.val & 1) == 0) {
                            return false;
                        }
                    } else {
                        // 奇数层
                        if (prev <= cur.val || (cur.val & 1) == 1) {
                            return false;
                        }
                    }
                    prev = cur.val;

                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                // 奇偶层数切换
                even = !even;
            }
            return true;
        }
    }
}
