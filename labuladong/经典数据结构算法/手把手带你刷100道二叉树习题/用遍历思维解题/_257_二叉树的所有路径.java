package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import java.util.LinkedList;
import java.util.List;
import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/binary-tree-paths/
public class _257_二叉树的所有路径 {
    public List<String> binaryTreePaths(TreeNode root) {
        // 遍历一遍二叉树就能出结果了
        traverse(root);
        return res;
    }

    // 记录 traverse 函数递归时的路径
    LinkedList<String> path = new LinkedList<>();
    // 记录所有从根节点到叶子节点的路径
    LinkedList<String> res = new LinkedList<>();

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        // root 是叶子节点
        if (root.left == null && root.right == null) {
            path.addLast(root.val + "");
            // 将这条路径装入 res
            res.addLast(String.join("->", path));
            path.removeLast();
            return;
        }
        
        // 前序遍历位置
        path.addLast(root.val + "");
        // 递归遍历左右子树
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        path.removeLast();
    }
}
