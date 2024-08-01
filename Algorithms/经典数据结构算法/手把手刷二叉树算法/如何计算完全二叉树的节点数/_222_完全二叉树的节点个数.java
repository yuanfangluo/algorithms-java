package Algorithms.经典数据结构算法.手把手刷二叉树算法.如何计算完全二叉树的节点数;

import Algorithms.Base.TreeNode;

// https://leetcode.cn/problems/count-complete-tree-nodes/
public class _222_完全二叉树的节点个数 {
    // 满二叉树的节点个数
    public int countNodes1(TreeNode root) {
        int h = 0;
        // 计算树的高度
        while (root != null) {
            root = root.left;
            h++;
        }
        // 节点总数就是 2^h - 1
        return (int) Math.pow(2, h) - 1;
    }

    // 完全二叉树
    // 由于完全二叉树的性质，其子树一定有一棵是满的，所以一定会触发 hl == hr，只消耗 O(logN) 的复杂度而不会继续递归。
    // 综上，算法的递归深度就是树的高度 O(logN)，每次递归所花费的时间就是 while 循环，需要 O(logN)，
    // 所以总体的时间复杂度是O(logN*logN)
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 沿最左侧和最右侧分别计算高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        // 如果左右侧计算的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        
        // 如果左右侧的高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}
