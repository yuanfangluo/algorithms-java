package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/
public class _1008_前序遍历构造二叉搜索树 {
    // 生成二叉树的题目，无非就是先生成根节点，然后递归生成左右子树，最后把根节点和左右子树连接起来。
    // 具体区别在于你如何找到根节点，如何划分左右子树。

    class Solution1 {
        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, 0, preorder.length - 1);
        }

        // 定义：将 preorder[start..end] 区间内的元素生成 BST，并返回根节点
        private TreeNode build(int[] preorder, int start, int end) {
            if (start > end) {
                return null;
            }

            // 根据前序遍历的特点，根节点在第一位，后面接着左子树和右子树
            int rootVal = preorder[start];
            TreeNode root = new TreeNode(rootVal);

            // 根据 BST 的特点，左子树都比根节点的值小，右子树都比根节点的值大
            // p 就是左右子树的分界点
            int p = start + 1;
            while (p <= end && preorder[p] < rootVal) {
                p++;
            }

            // [start+1, p-1] 区间内是左子树元素
            root.left = build(preorder, start + 1, p - 1);
            // [p, end] 区间内是右子树元素
            root.right = build(preorder, p, end);
            return root;
        }
    }

    class Solution2 {
        public TreeNode bstFromPreorder(int[] preorder) {
            TreeNode root = null;
            for (int i = 0; i < preorder.length; i++) {
                root = add(root, preorder[i]);
            }
            return root;
        }

        // 定义：将 num 插入到以 root 为根的 BST 中
        public TreeNode add(TreeNode root, int num) {
            if (root == null) {
                return new TreeNode(num);
            }

            if (root.val > num) {
                root.left = add(root.left, num);
            } else {
                root.right = add(root.right, num);
            }

            return root;
        }
    }
}
