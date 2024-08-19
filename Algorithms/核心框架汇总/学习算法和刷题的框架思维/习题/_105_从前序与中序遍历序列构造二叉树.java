package Algorithms.核心框架汇总.学习算法和刷题的框架思维.习题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class _105_从前序与中序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
            int[] inorder, int inStart, int inEnd) {

        // 前序位置，寻找左右子树的索引
        if (preStart > preEnd) {
            return null;
        }

        // 根节点的值
        int rootVal = preorder[preStart];

        // 在中序遍历中找根节点的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 左子树元素的个数
        int leftSize = index - inStart;

        // 构造根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
