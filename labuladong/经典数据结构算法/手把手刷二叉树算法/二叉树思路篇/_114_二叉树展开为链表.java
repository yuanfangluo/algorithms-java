package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉树思路篇;

import labuladong.Base.TreeNode;

/*
* https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
* 函数签名没有返回值，不能通过遍历+成员变量的方式来传值
* 我们这时候考虑使用分解问题的角度
* */
public class _114_二叉树展开为链表 {

    // 定义：输入节点root，然后以 root 为根的二叉树拉平为一条链表
    void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端

        TreeNode p = root;
        // （1）先找到当前右子树的末端
        while (p.right != null) {
            p = p.right;
        }
        // （2）将原先的右子树接到当前右子树的末端
        p.right = right;
    }

}
