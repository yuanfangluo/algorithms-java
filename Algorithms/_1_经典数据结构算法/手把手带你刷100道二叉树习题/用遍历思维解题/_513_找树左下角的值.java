package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/find-bottom-left-tree-value/
public class _513_找树左下角的值 {
    
    TreeNode res = null;
    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    // 二叉树的最大深度
    int maxDepth  = 0;
    // 记录递归遍历到的深度
    int depth = 0;
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // 前序遍历位置
        depth++;
        if (depth > maxDepth) {
            // 到最大深度时第一次遇到的节点就是左下角的节点
            maxDepth = depth;
            res = root;
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        depth--;
    }

    class Solution {
        int result =0;
        int max_deep = 0;
        public int findBottomLeftValue(TreeNode root) {
            get(root,0);
            return result;
        }
    
        public void get(TreeNode root,int deep){
            if(root==null) return;
            deep++;
            if(deep > max_deep){
                max_deep = deep;
                result = root.val;
            }
            get(root.left,deep);
            get(root.right,deep);
        }
    }

}
