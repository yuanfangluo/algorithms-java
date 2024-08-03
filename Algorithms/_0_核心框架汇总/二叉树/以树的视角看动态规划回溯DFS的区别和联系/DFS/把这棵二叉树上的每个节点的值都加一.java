package Algorithms._0_核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.DFS;

public class 把这棵二叉树上的每个节点的值都加一 {
    void traverse(TreeNode root) {
        if (root == null)
            return;
        // 遍历过的每个节点的值加一
        root.val++;
        traverse(root.left);
        traverse(root.right);
    }
}
