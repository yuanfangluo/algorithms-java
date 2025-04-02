package labuladong._1_经典数据结构算法.手把手带你刷100道二叉树习题.用分解问题思路解题;

import labuladong.Base.TreeNode;

// https://leetcode.cn/problems/symmetric-tree/
public class _101_对称二叉树 {
    
    // 那么分解问题的思路就很明显了，判断两棵树是否镜像对称，只要判断两棵子树都是镜像对称的就行了。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 检查两棵子树是否对称
        return check(root.left, root.right);
    }

    // 定义：判断输入的两棵树是否是镜像对称的
    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        // 两个根节点需要相同
        if (left.val != right.val) return false;
        
        // 左右子树也需要镜像对称
        return check(left.right, right.left) && check(left.left, right.right);
    }
}
