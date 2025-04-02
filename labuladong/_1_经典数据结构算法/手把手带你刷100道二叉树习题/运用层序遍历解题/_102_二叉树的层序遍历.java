package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.运用层序遍历解题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-level-order-traversal/
public class _102_二叉树的层序遍历 {
    class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 用来存储每一层的节点
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }

                if (node.right != null){
                    queue.add(node.right);
                }      
            }
            result.add(level);
        }
        return result;
    }
}
}
