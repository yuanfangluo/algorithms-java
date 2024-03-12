package LeetCode._3_二叉树;

import LeetCode.Base.TreeNode;

public class 每个节点所在的层数 {

    void printNodeLevel(TreeNode root) {
        // 这样调用
        traverse(root, 1);
    }

    // 二叉树遍历函数
     void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置
         System.out.println(root);
         System.out.println(level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

}
