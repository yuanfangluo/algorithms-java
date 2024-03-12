package LeetCode._3_二叉树;

import LeetCode.Base.TreeNode;

/*
* https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
* 函数签名没有返回值，不能通过遍历+成员变量的方式来传值
* 我们这时候考虑使用分解问题的角度
* */
public class _114_二叉树展开为链表 {

    // 定义：将以 root 为根的树拉平为链表
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
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
