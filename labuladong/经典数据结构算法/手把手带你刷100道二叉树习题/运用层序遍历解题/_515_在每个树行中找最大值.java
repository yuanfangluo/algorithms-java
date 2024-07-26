package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
public class _515_在每个树行中找最大值 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if (root == null) {
                return res;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                int sz = q.size();
                // 记录这一层的最大值
                int levelMax = Integer.MIN_VALUE;
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    levelMax = Math.max(levelMax, cur.val);
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                // 将这一层的最大值加入结果集
                res.add(levelMax);
            }
            return res;
        }
    }

    class Solution_DFS {
        // 一定要用 array 存储，因为要用索引随机访问
        ArrayList<Integer> res = new ArrayList<>();

        public List<Integer> largestValues(TreeNode root) {
            if (root == null) {
                return res;
            }
            traverse(root, 0);
            return res;
        }

        // 遍历二叉树
        void traverse(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            
            if (res.size() <= depth) {
                res.add(root.val);
            } else {
                // 记录当前行的最大值
                res.set(depth, Math.max(res.get(depth), root.val));
            }
            traverse(root.left, depth + 1);
            traverse(root.right, depth + 1);
        }
    }

}
