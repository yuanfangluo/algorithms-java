package Algorithms._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/
public class _971_翻转二叉树以匹配先序遍历 {
    
    // 遍历整棵二叉树，对比前序遍历结果，如果节点的值对不上，就无解;
    // 如果子树对不上voyage，就尝试翻转子树
    int[] voyage;
    boolean canFlip = true;
    List<Integer> res = new LinkedList<>();
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        // 遍历的过程中尝试进行反转
        traverse(root);
        if (canFlip) {
            return res;
        }
        return Arrays.asList(-1);
    }
    int i = 0;
    void traverse(TreeNode root) {
        if (root == null || !canFlip) {
            return;
        }

        if (root.val != voyage[i]) {
            // 节点的val对不上，必然无解
            canFlip = false;
            return;
        }
        i++;
        if (root.left != null && root.left.val != voyage[i]) {
            // 前序遍历结果不对，尝试翻转左右子树
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            // 记录翻转节点
            res.add(root.val);
        }
        traverse(root.left);
        traverse(root.right);
    }
}
