package Algorithms.核心框架汇总.二叉树.以树的视角看动态规划回溯DFS的区别和联系.回溯;

public class 多叉树 {
    // 多叉树节点
    class Node {
        int val;
        Node[] children;
    }

    void traverse(Node root) {
        if (root == null)
            return;
        for (Node child : root.children) {
            printf("从节点 %s 进入节点 %s", root, child);
            traverse(child);
            printf("从节点 %s 回到节点 %s", child, root);
        }
    }
}
