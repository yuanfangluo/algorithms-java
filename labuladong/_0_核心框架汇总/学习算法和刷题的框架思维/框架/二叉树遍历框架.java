package labuladong._0_核心框架汇总.学习算法和刷题的框架思维.框架;

import labuladong.Base.TreeNode;

public class 二叉树遍历框架 {
    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }
}
