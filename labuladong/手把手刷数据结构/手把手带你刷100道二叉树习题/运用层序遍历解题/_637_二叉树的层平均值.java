package labuladong.手把手刷数据结构.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/average-of-levels-in-binary-tree/
public class _637_二叉树的层平均值 {
    class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // 记录当前层所有节点之和
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                sum += cur.val;
            }
            // 记录当前行的平均值
            res.add(1.0 * sum / size);
        }

        return res;
    }
}
}
