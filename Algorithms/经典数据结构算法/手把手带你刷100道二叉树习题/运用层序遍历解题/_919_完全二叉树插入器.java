package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/complete-binary-tree-inserter/
public class _919_完全二叉树插入器 {
    class CBTInserter {
        // 这个队列只记录完全二叉树底部可以进行插入的节点
        private Queue<TreeNode> q = new LinkedList<>();

        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;

            // 进行普通的 BFS，目的是找到底部可插入的节点
            Queue<TreeNode> temp = new LinkedList<>();
            temp.offer(root);
            while (!temp.isEmpty()) {
                TreeNode cur = temp.poll();
                if (cur.left != null) {
                    temp.offer(cur.left);
                }
                if (cur.right != null) {
                    temp.offer(cur.right);
                }

                if (cur.right == null || cur.left == null) {
                    // 找到完全二叉树底部可以进行插入的节点
                    q.offer(cur);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode cur = q.peek();

            // 进行插入
            if (cur.left == null) {
                cur.left = node;
            } else if (cur.right == null) {
                cur.right = node;
                // 代表此节点的左右节点都已经插入完毕，弹出
                q.poll();
            }

            // 新节点的左右节点也是可以插入的
            q.offer(node);
            return cur.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
