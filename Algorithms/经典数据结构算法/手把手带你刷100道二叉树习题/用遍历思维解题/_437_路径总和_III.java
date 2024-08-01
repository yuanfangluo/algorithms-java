package Algorithms.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.HashMap;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/path-sum-iii/
public class _437_路径总和_III {

    int pathSum = 0;
    int targetSum;
    int res = 0;

    // 记录前缀和
    // 定义：从二叉树的根节点开始，路径和为 pathSum 的路径有 preSumCount.get(pathSum) 个
    // (key, value) = (pathSum, count)
    HashMap<Integer, Integer> preSumCount = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        this.targetSum = targetSum;
        preSumCount.put(0, 1);
        traverse(root);
        return res;

    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        pathSum += root.val;

        // 从二叉树的根节点开始，路径和为 pathSum - targetSum的路径条数
        // 就是路径和为 targetSum 的路径条数
        res += preSumCount.getOrDefault(pathSum - targetSum, 0);

        // 记录从二叉树的根节点开始，路径和为 pathSum 的路径条数
        preSumCount.put(pathSum, preSumCount.getOrDefault(pathSum, 0) + 1);

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        preSumCount.put(pathSum, preSumCount.get(pathSum) - 1);
        pathSum -= root.val;
    }

    class Solution {
        public int pathSum(TreeNode root, long targetSum) {
            if (root == null) {
                return 0;
            }

            int ret = rootSum(root, targetSum);
            ret += pathSum(root.left, targetSum);
            ret += pathSum(root.right, targetSum);
            return ret;
        }

        public int rootSum(TreeNode root, long targetSum) {
            int ret = 0;

            if (root == null) {
                return 0;
            }
            int val = root.val;
            if (val == targetSum) {
                ret++;
            }

            ret += rootSum(root.left, targetSum - val);
            ret += rootSum(root.right, targetSum - val);
            return ret;
        }
    }
}
