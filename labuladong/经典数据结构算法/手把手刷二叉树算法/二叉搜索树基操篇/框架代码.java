package labuladong.经典数据结构算法.手把手刷二叉树算法.二叉搜索树基操篇;

import labuladong.Base.TreeNode;

public class 框架代码 {
    void BST(TreeNode root, int target) {
        if (root.val == target)
            // 找到目标，做点什么
        if (root.val < target) 
            BST(root.right, target);
        if (root.val > target)
            BST(root.left, target);
    }
}
