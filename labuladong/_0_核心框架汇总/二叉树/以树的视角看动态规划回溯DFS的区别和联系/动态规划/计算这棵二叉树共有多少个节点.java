package labuladong._0_核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.动态规划;

import labuladong.Base.TreeNode;

public class 计算这棵二叉树共有多少个节点 {
    // 定义：输入一棵二叉树，返回这棵二叉树的节点总数
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 当前节点关心的是两个子树的节点总数分别是多少
        // 因为用子问题的结果可以推导出原问题的结果
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        // 后序位置，左右子树节点数加上自己就是整棵树的节点数
        return leftCount + rightCount + 1;
    }
}
