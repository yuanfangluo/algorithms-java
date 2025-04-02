package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用遍历思维解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/cousins-in-binary-tree/
public class _993_二叉树的堂兄弟节点 {
    // 遍历找到 x，y 的深度和父节点，对比即可。

    TreeNode parentX = null;
    TreeNode parentY = null;
    int depthX = 0, depthY = 0;
    int x, y;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        traverse(root, 0, null);

        if (depthX == depthY && parentX != parentY) {
            // 判断 x，y 是否是表兄弟节点
            return true;
        }

        return false;

    }

    void traverse(TreeNode root, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            // 找到 x，记录它的深度和父节点
            parentX = parent;
            depthX = depth;
        }
        if (root.val == y) {
            // 找到 y，记录它的深度和父节点
            parentY = parent;
            depthY = depth;
        }
        traverse(root.left, depth + 1, root);
        traverse(root.right, depth + 1, root);
    }
}
