package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/maximum-width-of-binary-tree/
public class _662_二叉树最大宽度 {
    // 层序遍历思路
    class Solution {
        // 记录节点和对应编号
        class Pair {
            TreeNode node;
            int id;

            public Pair(TreeNode node, int id) {
                this.node = node;
                this.id = id;
            }
        }

        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 记录最大的宽度
            int maxWidth = 0;
            // 标准 BFS 层序遍历算法
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 1));
            // 从上到下遍历整棵树
            while (!q.isEmpty()) {
                int sz = q.size();
                int start = 0, end = 0;
                // 从左到右遍历每一行
                for (int i = 0; i < sz; i++) {
                    Pair cur = q.poll();
                    TreeNode curNode = cur.node;
                    int curId = cur.id;
                    // 记录当前行第一个和最后一个节点的编号
                    if (i == 0) {
                        start = curId;
                    }
                    if (i == sz - 1) {
                        end = curId;
                    }
                    // 左右子节点入队，同时记录对应节点的编号
                    if (curNode.left != null) {
                        q.offer(new Pair(curNode.left, curId * 2));
                    }
                    if (curNode.right != null) {
                        q.offer(new Pair(curNode.right, curId * 2 + 1));
                    }
                }
                // 用当前行的宽度更新最大宽度
                maxWidth = Math.max(maxWidth, end - start + 1);
            }

            return maxWidth;
        }
    }

    // 递归遍历思路
    class Solution2 {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            traverse(root, 1, 1);
            return maxWidth;
        }

        // 记录最左侧节点的编号
        ArrayList<Integer> firstId = new ArrayList<>();
        int maxWidth = 1;

        // 二叉树遍历函数
        void traverse(TreeNode root, int id, int depth) {
            if (root == null) {
                return;
            }

            if (firstId.size() == depth - 1) {
                // 因为代码是先 traverse(root.left) 后 traverse(root.right)，
                // 所以第一次到达这个深度一定是最左侧的节点，记录其编号
                firstId.add(id);
            } else {
                // 这个深度的其他节点，负责计算更新当前深度的最大宽度
                maxWidth = Math.max(maxWidth, id - firstId.get(depth - 1) + 1);
            }

            traverse(root.left, id * 2, depth + 1);
            traverse(root.right, id * 2 + 1, depth + 1);
        }
    }
}
