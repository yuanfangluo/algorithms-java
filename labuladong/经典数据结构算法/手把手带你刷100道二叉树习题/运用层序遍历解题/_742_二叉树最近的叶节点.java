package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/closest-leaf-in-a-binary-tree/
public class _742_二叉树最近的叶节点 {

    class Solution1 {
        class Solution {
            private int minPath = Integer.MAX_VALUE;
            private int value = 0;

            // Time complexity O(n)
            // Space complexity O(n)
            public int findClosestLeaf(TreeNode root, int k) {
                findPath(root, k);
                return value;
            }

            private int findPath(TreeNode root, int k) {
                if (root == null) {
                    return 0;
                } else if (root.val == k) {
                    findLeaf(root, 0);
                    return 1;
                } else {
                    int leftPath = findPath(root.left, k);
                    if (leftPath > 0) {
                        findLeaf(root.right, leftPath);
                        return leftPath + 1;
                    }

                    int rightPath = findPath(root.right, k);
                    if (rightPath > 0) {
                        findLeaf(root.left, rightPath);
                        return rightPath + 1;
                    }
                    return 0;
                }
            }

            private void findLeaf(TreeNode root, int path) {
                path++;
                if (root != null && path < minPath) {
                    if (root.left == null && root.right == null) {
                        minPath = path;
                        value = root.val;
                    }

                    if (root.left != null) {
                        findLeaf(root.left, path);
                    }
                    if (root.right != null) {
                        findLeaf(root.right, path);
                    }
                }
            }

        }
    }

    // 先用 DFS 递归遍历找到值为 k 的节点 target，并且构建子节点到父节点的映射，这样就把二叉树变成了一幅图；
    // 然后从 target 节点开始进行 BFS 算法，第一次遇到的叶子节点就是距离最近的叶子结点。
    // 说个细节，注意 traverse 函数的结束条件，找到 target 之后就会停止递归，也就是说并没有将整棵树的子节点到父节点的映射都构建出来。

    class Solution {
        public int findClosestLeaf(TreeNode root, int k) {
            // 找到目标节点并构建所需的子节点到父节点的映射
            traverse(root, k, null);

            // 执行 BFS 算法
            Queue<TreeNode> q = new LinkedList<>();
            HashSet<TreeNode> visited = new HashSet<>();
            q.offer(target);
            visited.add(target);

            while (!q.isEmpty()) {
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left == null && cur.right == null) {
                        // BFS 首次到达的叶子结点就是最近的叶子结点
                        return cur.val;
                    }

                    if (cur.left != null && !visited.contains(cur.left)) {
                        q.offer(cur.left);
                        visited.add(cur.left);
                    }
                    if (cur.right != null && !visited.contains(cur.right)) {
                        q.offer(cur.right);
                        visited.add(cur.right);
                    }
                    TreeNode parentNode = parentMap.get(cur);
                    if (parentNode != null && !visited.contains(parentNode)) {
                        q.offer(parentNode);
                        visited.add(parentNode);
                    }
                }
            }
            return -1;
        }

        TreeNode target = null;
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        // 遍历函数，找到值为 k 的那个节点，同时记录子节点到父节点的映射
        void traverse(TreeNode root, int k, TreeNode parent) {
            if (root == null || target != null) {
                return;
            }
            // 记录子节点到父节点的映射
            parentMap.put(root, parent);

            if (root.val == k) {
                target = root;
                return;
            }

            traverse(root.left, k, root);
            traverse(root.right, k, root);
        }
    }

}
