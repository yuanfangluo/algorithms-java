package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/deepest-leaves-sum/
public class _1302_层数最深叶子节点的和 {
    // 你把每层的节点值加起来，到最后就是最后一层了
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if (root == null)
                return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int sum = 0;
            while (!q.isEmpty()) {
                sum = 0;
                int sz = q.size();
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    // 累加一层的节点之和
                    sum += cur.val;
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
            }

            // 现在就是最后一层的节点值和
            return sum;
        }
    }
}
