package labuladong.BinaryTree;

import labuladong.Base.TreeNode;

/*
* https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
*
* */
public class _116_填充每个节点的下一个右侧节点指针 {
    // 遍历的思路
    // 传统的 traverse 函数是遍历二叉树的所有节点，但现在我们想遍历的其实是两个相邻节点之间的「空隙」。
    // 这样，一棵二叉树被抽象成了一棵三叉树，三叉树上的每个节点就是原先二叉树的两个相邻节点。
    // 现在，我们只要实现一个 traverse 函数来遍历这棵三叉树，
    // 每个「三叉树节点」需要做的事就是把自己内部的两个二叉树节点穿起来：

    // 主函数
    TreeNode connect(TreeNode root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    void traverse(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;

        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }

}
