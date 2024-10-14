package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
public class _1161_最大层内元素和 {
    class Solution {
        public int maxLevelSum(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // 记录 BFS 走到的层数
            int depth = 1;
            // 记录元素和最大的那一行和最大元素和
            int res = 0, maxSum = Integer.MIN_VALUE;

            while (!q.isEmpty()) {
                int sz = q.size();
                int levelSum = 0;
                // 遍历这一层
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    levelSum += cur.val;

                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                // 到这里代表这一层结束
                if (levelSum > maxSum) {
                    // 更新最大元素和
                    res = depth;
                    maxSum = levelSum;
                }
                // 
                depth++;
            }
            return res;
        }
    }
}
