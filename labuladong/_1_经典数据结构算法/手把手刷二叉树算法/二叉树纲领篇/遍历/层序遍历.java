package labuladong._1_经典数据结构算法.手把手刷二叉树算法.二叉树纲领篇.遍历;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

public class 层序遍历 {
    
    void levelTraverse(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!q.isEmpty()) {
            int sz = q.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
