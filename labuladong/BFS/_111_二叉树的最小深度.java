package labuladong.BFS;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

/*
* https://leetcode.cn/problems/minimum-depth-of-binary-tree/
*
*
* */
public class _111_二叉树的最小深度 {

    // BFS 借助队列做到一次一步「齐头并进」，是可以在不遍历完整棵树的条件下找到最短距离的
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root 本身就是一层，depth 初始化为 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 遍历当前一层的节点 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达叶子结点 */
                // 第一次到达终点的时候，走的步数是最少的
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将下一层节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 这里增加步数 */
            depth++;
        }
        return depth;
    }

    int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null) {
            return minDepth2(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth2(root.left) + 1;
        }

        int minLeft = minDepth2(root.left);
        int minRight = minDepth2(root.right);
        int res = Math.min(minLeft, minRight) + 1;
        return res;
    }

}
