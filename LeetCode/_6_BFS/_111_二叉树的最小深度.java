package LeetCode._6_BFS;

import LeetCode.Base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
* https://leetcode.cn/problems/minimum-depth-of-binary-tree/
*
*
* */
public class _111_二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
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


}
