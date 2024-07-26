package labuladong.经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;
// https://leetcode.cn/problems/sum-root-to-leaf-numbers/

public class _129_求根节点到叶节点数字之和 {
    StringBuilder path = new StringBuilder();
    int res = 0;
    public int sumNumbers(TreeNode root) {
        // 遍历一遍二叉树就能出结果
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置，记录节点值
        path.append(root.val);
        
        if (root.left == null && root.right == null) {
            // 到达叶子节点，累加路径和
            res += Integer.parseInt(path.toString());
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置，撤销节点值
        path.deleteCharAt(path.length() - 1);

    }
}
