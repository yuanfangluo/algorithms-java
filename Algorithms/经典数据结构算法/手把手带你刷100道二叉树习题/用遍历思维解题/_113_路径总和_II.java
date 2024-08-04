package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.ArrayList;
import java.util.List;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/path-sum-ii/
public class _113_路径总和_II {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null)
                return list;
            dfs(root, sum, new ArrayList<>(), list);
            return list;
        }
        
        private void dfs(TreeNode node, int remain, List<Integer> nums, List<List<Integer>> list) {
            if (node == null)
                return;
            ;

            remain -= node.val;

            nums.add(node.val);

            // remain == 0不代表结束了，还要是叶子节点

            if (node.left == null && node.right == null) {
                if (remain == 0) {
                    list.add(new ArrayList<>(nums));
                }
            } else {
                dfs(node.left, remain, nums, list);
                dfs(node.right, remain, nums, list);
            }

            // 恢复现场
            nums.remove(nums.size() - 1);
        }
    }
}
