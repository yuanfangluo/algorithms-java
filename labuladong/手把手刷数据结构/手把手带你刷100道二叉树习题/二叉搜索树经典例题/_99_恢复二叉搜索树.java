package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/recover-binary-search-tree/
public class _99_恢复二叉搜索树 {
    class Solution1 {

        // 分别记录这两个被交换的节点
        TreeNode first = null, second = null;
        // 判断中序遍历的有序性
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            inorderTraverse(root);

            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

        void inorderTraverse(TreeNode root) {
            if (root == null) {
                return;
            }

            inorderTraverse(root.left);

            // 中序代码位置，找出那两个节点
            if (root.val < prev.val) {
                // root 不符合有序性
                if (first == null) {
                    // 第一个错位节点是 prev
                    first = prev;
                }
                // 第二个错位节点是 root
                second = root;
            }
            // 更新 prev
            prev = root;

            inorderTraverse(root.right);
        }
    }

    // Morris 遍历算法，该算法能将非递归的中序遍历空间复杂度降为 O(1)
    class Solution2 {
        public void recoverTree(TreeNode root) {
            TreeNode x = null, y = null, pred = null, predecessor = null;
            while (root != null) {
                if (root.left != null) {
                    // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                    predecessor = root.left;
                    while (predecessor.right != null && predecessor.right != root) {
                        predecessor = predecessor.right;
                    }
                    
                    // 让 predecessor 的右指针指向 root，继续遍历左子树
                    if (predecessor.right == null) {
                        predecessor.right = root;
                        root = root.left;
                    }
                    // 说明左子树已经访问完了，我们需要断开链接
                    else {
                        if (pred != null && root.val < pred.val) {
                            y = root;
                            if (x == null) {
                                x = pred;
                            }
                        }
                        pred = root;
    
                        predecessor.right = null;
                        root = root.right;
                    }
                }
                // 如果没有左孩子，则直接访问右孩子
                else {
                    if (pred != null && root.val < pred.val) {
                        y = root;
                        if (x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    root = root.right;
                }
            }
            swap(x, y);
        }
    
        public void swap(TreeNode x, TreeNode y) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }
}
