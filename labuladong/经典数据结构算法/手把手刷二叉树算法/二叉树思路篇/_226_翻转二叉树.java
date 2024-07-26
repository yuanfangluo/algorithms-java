package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉树思路篇;

import labuladong.Base.TreeNode;

/*
* https://leetcode.cn/problems/invert-binary-tree/
*
* */
public class _226_翻转二叉树 {

    // 遍历
    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        /**** 前序位置 ****/
        // 每一个节点需要做的事就是交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    // 分解问题
    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }


}
