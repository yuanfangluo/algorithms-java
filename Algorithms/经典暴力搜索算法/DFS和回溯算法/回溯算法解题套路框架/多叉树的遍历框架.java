package Algorithms.经典暴力搜索算法.DFS和回溯算法.回溯算法解题套路框架;

import java.util.List;

public class 多叉树的遍历框架 {
    class TreeNode {
        List<TreeNode> childern;
    }

    void traverse(TreeNode root) {
        for (TreeNode child : root.childern) {
            // 前序位置需要的操作
            traverse(child);
            // 后序位置需要的操作
        }
    }
}
