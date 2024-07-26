package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/check-completeness-of-a-binary-tree/
public class _958_二叉树的完全性检验 {
    // 如果按照 BFS 层序遍历的方式遍历完全二叉树，队列最后留下的应该都是空指针：
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // 遍历完所有非空节点时变成 true
            boolean end = false;
            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                int sz = q.size();
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    if (cur == null) {
                        // 第一次遇到 null 时 end 变成 true
                        // 如果之后的所有节点都是 null，则说明是完全二叉树
                        end = true;
                    } else {
                        if (end) {
                            // end 为 true 时遇到非空节点说明不是完全二叉树
                            return false;
                        }
                        // 将下一层节点放入队列，不用判断是否非空
                        q.offer(cur.left);
                        q.offer(cur.right);
                    }
                }
            }
            return true;
        }
    }
}
