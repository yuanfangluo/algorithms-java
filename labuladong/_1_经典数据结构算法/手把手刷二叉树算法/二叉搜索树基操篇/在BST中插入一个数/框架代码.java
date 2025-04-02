package labuladong._1_经典数据结构算法.手把手刷二叉树算法.二叉搜索树基操篇.在BST中插入一个数;

import labuladong.Base.TreeNode;

public class 框架代码 {
    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) 
            root.right = insertIntoBST(root.right, val);
        if (root.val > val) 
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}
