package labuladong._0_核心框架汇总.BFS算法解题套路框架;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/
public class _111_二叉树的最小深度 {

    // 怎么套到 BFS 的框架里呢？首先明确一下起点 start 和终点 target 是什么，怎么判断到达了终点？
    // 显然起点就是 root 根节点，终点就是最靠近根节点的那个「叶子节点」
    class Solution {
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
    }

}
