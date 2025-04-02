package labuladong._1_经典数据结构算法.手把手刷图算法.Dijkstra算法模板及应用;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

public class 二叉树的层序遍历框架 {
    // 输入一棵二叉树的根节点，层序遍历这棵二叉树
    void levelTraverse(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int depth = 1;
        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.println("节点" + cur.val + "在第" + depth + "层");
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }
}
