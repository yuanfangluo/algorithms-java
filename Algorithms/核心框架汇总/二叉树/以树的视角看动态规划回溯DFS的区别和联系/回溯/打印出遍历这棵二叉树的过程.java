package Algorithms.核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.回溯;

import Algorithms.Base.TreeNode;

public class 打印出遍历这棵二叉树的过程 {
    void traverse(TreeNode root) {
        if (root == null)
            return;
        System.out.printf("从节点 %s 进入节点 %s", root, root.left);
        traverse(root.left);
        System.out.printf("从节点 %s 回到节点 %s", root.left, root);


        System.out.printf("从节点 %s 进入节点 %s", root, root.right);
        traverse(root.right);
        System.out.printf("从节点 %s 回到节点 %s", root.right, root);

    }
}
