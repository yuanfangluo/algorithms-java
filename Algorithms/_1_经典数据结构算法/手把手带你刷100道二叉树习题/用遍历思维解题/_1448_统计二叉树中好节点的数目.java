package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
public class _1448_统计二叉树中好节点的数目 {
    
    // 函数参数 pathMax 记录从根节点到当前节点路径中的最大值，
    // 通过比较 root.val 和 pathMax 比较就可判断 root 节点是不是「好节点」。
    // 然后再把 pathMax 传递到子树中继续判断其他节点。

    int count = 0;
    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return count;
    }

    // 二叉树遍历函数，pathMax 参数记录从根节点到当前节点路径中的最大值
    void traverse(TreeNode root, int pathMax) {
        if (root == null) {
            return;
        }

        if (pathMax <= root.val) {
            // 找到一个【好节点】
            count++;
        }

        pathMax = Math.max(pathMax, root.val);
        traverse(root.left, pathMax);
        traverse(root.right, pathMax);
    } 

    class Solution {
        public int goodNodes(TreeNode root) {
           return dfs(root,Integer.MIN_VALUE);
        }

        public int dfs(TreeNode root,int pathMax){
            if(root==null){
                return 0;
            }
            int res = 0;
            if(root.val>=pathMax){
                res++;
                pathMax = root.val;
            }
            res += dfs(root.left,pathMax)+dfs(root.right,pathMax);
            return res;
        }
    }
}
