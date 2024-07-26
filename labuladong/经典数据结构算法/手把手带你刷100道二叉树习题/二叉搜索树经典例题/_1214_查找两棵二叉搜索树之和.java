package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.二叉搜索树经典例题;

import java.util.ArrayList;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/two-sum-bsts/
public class _1214_查找两棵二叉搜索树之和 {

    class Solution1 {
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            if (root2 == null) {
                return false;
            }
            int diff = target - root2.val;
            TreeNode cur = root1;

            while (cur != null) {
                if (cur.val == diff) {
                    return true;
                }
                if (cur.val < diff) {
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
            return twoSumBSTs(root1, root2.left, target) || twoSumBSTs(root1, root2.right, target);
        }
    }

    // 二叉树中序遍历代码得到 BST 的中序遍历有序结果，然后用 一个函数秒杀 nSum 问题 中解决两数之和的算法思路搜索目标和 target。
    class Solution2 {
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            // 将两个 BST 转化成两个有序数组
            ArrayList<Integer> arr1 = traverse(root1);
            ArrayList<Integer> arr2 = traverse(root2);
            int m = arr1.size(), n = arr2.size();

            // 对有序数组执行两数之和问题的算法逻辑
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                int sum = arr1.get(i) + arr2.get(j);
                if (sum < target) {
                    // 让和大一些
                    i++;
                } else if (sum > target) {
                    // 让和小一些
                    j--;
                } else {
                    // 找到和 target
                    return true;
                }
            }
            return false;
        }

        // 返回中序遍历结果
        ArrayList<Integer> traverse(TreeNode root) {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            res.addAll(traverse(root.left));
            res.add(root.val);
            res.addAll(traverse(root.right));
            return res;
        }
    }
}
